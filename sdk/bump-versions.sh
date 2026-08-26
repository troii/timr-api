#!/usr/bin/env bash
# Bumps the versions in sdk/versions.properties.
#
#   sdk/bump-versions.sh minor              every SDK, for a release that follows a specification update
#   sdk/bump-versions.sh patch python       one or more SDKs, for a generator, template or packaging fix
#
# A specification update carries every client with it, so the whole set moves together; a fix that is
# one client's own moves that client alone. Names are the module directories under sdk/. See
# VERSIONING.md for which level a change calls for.
set -euo pipefail

versions="$(cd "$(dirname "$0")" && pwd)/versions.properties"

usage() {
  echo "usage: $(basename "$0") minor|patch [sdk...]" >&2
  exit 2
}

[ $# -ge 1 ] || usage
level=$1
shift
case $level in
  minor | patch) ;;
  *) usage ;;
esac

declared=$(grep -oE '^[^#][^=]*' "$versions" | sed 's/[[:space:]]*$//')

# Resolve every requested name before touching the file, so a typo cannot leave a half applied bump.
if [ $# -eq 0 ]; then
  selected=$declared
else
  selected=""
  for name in "$@"; do
    match=$(printf '%s\n' "$declared" | grep -xF "$name" || true)
    case $(printf '%s' "$match" | grep -c .) in
      1) selected="$selected$match"$'\n' ;;
      0)
        echo "error: $versions declares no SDK matching '$name'" >&2
        exit 1
        ;;
      *)
        echo "error: '$name' matches more than one SDK:" >&2
        printf '  %s\n' $match >&2
        exit 1
        ;;
    esac
  done
fi

bump() {
  local current=$1
  if ! [[ $current =~ ^([0-9]+)\.([0-9]+)\.([0-9]+)$ ]]; then
    echo "error: '$current' is not a version this script can bump" >&2
    exit 1
  fi
  local major=${BASH_REMATCH[1]} minor_part=${BASH_REMATCH[2]} patch_part=${BASH_REMATCH[3]}
  if [ "$level" = minor ]; then
    echo "$major.$((minor_part + 1)).0"
  else
    echo "$major.$minor_part.$((patch_part + 1))"
  fi
}

for name in $selected; do
  current=$(grep -E "^$name=" "$versions" | cut -d= -f2)
  next=$(bump "$current")
  # Rewrite in place, leaving the comments and the order of the file alone.
  awk -v name="$name" -v bumped="$next" -F= '
    $1 == name { print name "=" bumped; next }
    { print }
  ' "$versions" > "$versions.rewritten"
  mv "$versions.rewritten" "$versions"
  printf '%-24s %s -> %s\n' "$name" "$current" "$next"
done
