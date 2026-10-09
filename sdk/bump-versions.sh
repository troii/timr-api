#!/usr/bin/env bash
# Bumps the versions in sdk/versions.properties.
#
#   sdk/bump-versions.sh minor              every SDK, for a release that follows a specification update
#   sdk/bump-versions.sh patch python       one or more SDKs, for a generator, template or packaging fix
#   sdk/bump-versions.sh tag [java-restclient ...]  tag HEAD for one or more publishable SDKs
#
# A specification update carries every client with it, so the whole set moves together; a fix that is
# one client's own moves that client alone. Names are the module directories under sdk/. See
# VERSIONING.md for which level a change calls for.
#
# `tag` is the release: pushing a module tag publishes that SDK. It refuses while versions.properties
# has uncommitted changes, so a tag always names a version that is in the commit it points at.
set -euo pipefail

versions="$(cd "$(dirname "$0")" && pwd)/versions.properties"

usage() {
  echo "usage: $(basename "$0") minor|patch|tag [sdk...]" >&2
  exit 2
}

[ $# -ge 1 ] || usage
level=$1
shift
case $level in
  minor | patch | tag) ;;
  *) usage ;;
esac

declared=$(grep -oE '^[^#][^=]*' "$versions" | sed 's/[[:space:]]*$//')
publishable=$'java-restclient\njava-resttemplate\nkotlin-okhttp\ndotnet'

# Resolve every requested name before touching the file, so a typo cannot leave a half applied bump.
if [ $# -eq 0 ]; then
  if [ "$level" = tag ]; then
    selected=$publishable
  else
    selected=$declared
  fi
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

if [ "$level" = tag ]; then
  for name in $selected; do
    if ! printf '%s\n' "$publishable" | grep -qxF "$name"; then
      echo "error: publishing is not configured for SDK '$name'" >&2
      exit 1
    fi
  done
  if ! git -C "$(dirname "$versions")" diff --quiet HEAD -- versions.properties; then
    echo "error: sdk/versions.properties has uncommitted changes; commit the bump before tagging" >&2
    exit 1
  fi
  for name in $selected; do
    current=$(grep -E "^$name=" "$versions" | cut -d= -f2)
    git tag -a "$name/$current" -m "$name $current"
    printf '%-24s tagged %s\n' "$name" "$name/$current"
  done
  exit 0
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
