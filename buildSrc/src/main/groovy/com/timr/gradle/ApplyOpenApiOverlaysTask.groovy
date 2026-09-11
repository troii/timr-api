package com.timr.gradle

import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.Option
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.SafeConstructor

/**
 * Applies OpenAPI Overlay 1.0 documents to a specification.
 *
 * Unmatched targets fail the build rather than being skipped as the specification allows: a
 * silently ignored action is how an overlay drifts away from the contract it patches.
 */
class ApplyOpenApiOverlaysTask extends DefaultTask {

    @InputFile
    final RegularFileProperty baseSpec = project.objects.fileProperty()

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    final ConfigurableFileCollection overlays = project.objects.fileCollection()

    @OutputFile
    final RegularFileProperty outputSpec = project.objects.fileProperty()

    protected static final Configuration PATHS = Configuration.builder()
            .options(Option.AS_PATH_LIST, Option.SUPPRESS_EXCEPTIONS)
            .build()

    @TaskAction
    void apply() {
        def spec = loadYaml(baseSpec.get().asFile)
        overlays.files.findAll { it.exists() }.unique().each { overlayFile ->
            applyOverlay(spec, loadYaml(overlayFile), overlayFile.name)
        }
        writeYaml(spec, outputSpec.get().asFile)
    }

    protected static void applyOverlay(Object spec, Object overlay, String name) {
        if (overlay == null) {
            return
        }
        if (!(overlay instanceof Map) || !((Map) overlay).containsKey('actions')) {
            throw new GradleException("$name is not an Overlay document: expected an 'actions' array")
        }
        def actions = ((Map) overlay).actions
        if (!(actions instanceof List)) {
            throw new GradleException("$name: 'actions' must be a list")
        }
        actions.eachWithIndex { Object action, int index ->
            if (!(action instanceof Map)) {
                throw new GradleException("$name: action #$index must be a mapping")
            }
            applyAction(spec, (Map) action, "$name action #$index")
        }
    }

    protected static void applyAction(Object spec, Map action, String where) {
        def target = action.target as String
        if (!target) {
            throw new GradleException("$where is missing a target")
        }
        List<String> matches = JsonPath.using(PATHS).parse(spec).read(target) as List<String>
        if (!matches) {
            throw new GradleException("$where matches nothing: $target")
        }
        boolean remove = action.remove == true
        if (remove && action.containsKey('update')) {
            throw new GradleException("$where must not combine 'remove' with 'update'")
        }
        matches.each { String path ->
            def tokens = parsePath(path)
            if (remove) {
                removeAt(spec, tokens)
            } else {
                merge(resolve(spec, tokens), action.update)
            }
        }
    }

    /** Splits a JsonPath-normalised path such as {@code $['a'][0]['b']} into its tokens. */
    protected static List<Object> parsePath(String path) {
        def tokens = []
        def matcher = path =~ /\[(?:'([^']*)'|(\d+))]/
        while (matcher.find()) {
            tokens << (matcher.group(1) != null ? matcher.group(1) : Integer.parseInt(matcher.group(2)))
        }
        tokens
    }

    protected static Object resolve(Object root, List<Object> tokens) {
        tokens.inject(root) { node, token -> child(node, token) }
    }

    protected static Object child(Object node, Object token) {
        if (node instanceof Map) {
            return ((Map) node).get(token)
        }
        if (node instanceof List && token instanceof Integer) {
            return ((List) node).get((int) token)
        }
        throw new GradleException("Cannot navigate into ${node?.class?.simpleName} with '$token'")
    }

    protected static void removeAt(Object root, List<Object> tokens) {
        if (tokens.isEmpty()) {
            throw new GradleException('Cannot remove the document root')
        }
        def parent = resolve(root, tokens[0..<tokens.size() - 1])
        def last = tokens.last()
        if (parent instanceof Map) {
            ((Map) parent).remove(last)
        } else if (parent instanceof List && last instanceof Integer) {
            ((List) parent).remove((int) last)
        }
    }

    /**
     * Deep-merges an update into the target node. Maps merge recursively; everything else replaces,
     * which is what Overlay 1.0 prescribes for scalars and arrays.
     */
    protected static void merge(Object target, Object update) {
        if (update == null) {
            return
        }
        if (!(target instanceof Map) || !(update instanceof Map)) {
            throw new GradleException('An update can only be merged into a mapping')
        }
        Map targetMap = (Map) target
        ((Map) update).each { key, value ->
            if (isExtension(key)) {
                normaliseRefSibling(targetMap)
            }
            def existing = targetMap.get(key)
            if (existing instanceof Map && value instanceof Map) {
                merge(existing, value)
            } else {
                targetMap.put(key, value)
            }
        }
    }

    protected static boolean isExtension(Object key) {
        key instanceof String && ((String) key).startsWith('x-')
    }

    /**
     * A sibling of {@code $ref} is ignored by JSON Schema, so wrap the reference in an allOf before
     * an extension is added next to it.
     */
    protected static void normaliseRefSibling(Map node) {
        if (!node.containsKey('$ref')) {
            return
        }
        def ref = node.remove('$ref')
        def allOf = node.get('allOf')
        if (!(allOf instanceof List)) {
            node.put('allOf', [['$ref': ref]])
        } else if (!allOf.any { it instanceof Map && ((Map) it).get('$ref') == ref }) {
            allOf.add(0, ['$ref': ref])
        }
    }

    protected static Object loadYaml(File file) {
        if (!file.exists()) {
            throw new GradleException("Spec file not found: $file")
        }
        def loaderOptions = new LoaderOptions()
        loaderOptions.codePointLimit = 16 * 1024 * 1024
        def yaml = new Yaml(new SafeConstructor(loaderOptions))
        file.withReader('UTF-8') { reader -> yaml.load(reader) }
    }

    protected static void writeYaml(Object data, File destination) {
        destination.parentFile.mkdirs()
        def options = new DumperOptions()
        options.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
        options.prettyFlow = true
        options.indent = 2
        options.indicatorIndent = 1
        options.defaultScalarStyle = DumperOptions.ScalarStyle.PLAIN
        destination.withWriter('UTF-8') { writer -> new Yaml(options).dump(data, writer) }
    }
}
