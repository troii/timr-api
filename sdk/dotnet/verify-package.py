import argparse
from pathlib import Path
import re
import xml.etree.ElementTree as ET
from zipfile import ZipFile

parser = argparse.ArgumentParser(description="Verify the .NET SDK's NuGet publication.")
parser.add_argument("package", type=Path)
parser.add_argument("--version", required=True)
parser.add_argument("--snapshot", action="store_true")
args = parser.parse_args()

with ZipFile(args.package) as package:
    entries = package.namelist()
    nuspecs = [entry for entry in entries if entry.endswith(".nuspec")]
    assert len(nuspecs) == 1, "Expected one NuGet manifest"
    manifest = ET.fromstring(package.read(nuspecs[0]))
    ns = {"n": manifest.tag.split("}")[0].removeprefix("{")}
    metadata = manifest.find("n:metadata", ns)
    assert metadata.findtext("n:id", namespaces=ns) == "timr.Api"
    version = metadata.findtext("n:version", namespaces=ns)
    expected = re.escape(args.version)
    if args.snapshot:
        expected += r"-snapshot\.\d+(?:\.\d+)?"
    assert re.fullmatch(expected, version), f"Unexpected package version: {version}"
    assert args.package.name == f"timr.Api.{version}.nupkg"
    license = metadata.find("n:license", ns)
    assert license.attrib["type"] == "expression" and license.text == "Apache-2.0"
    repository = metadata.find("n:repository", ns)
    assert repository.attrib["url"] == "https://github.com/troii/timr-api"
    readme = metadata.findtext("n:readme", namespaces=ns)
    assert readme in entries and package.read(readme), "Missing package README"
    for framework in ["net8.0", "net10.0"]:
        for extension in ["dll", "xml"]:
            entry = f"lib/{framework}/Timr.Api.{extension}"
            assert entry in entries and package.read(entry), f"Missing {entry}"
    assert all(not entry.endswith((".cs", ".csproj")) for entry in entries)

print(f"Verified timr.Api {version}: .NET 8/10 assemblies, XML documentation, license, README, and repository metadata")
