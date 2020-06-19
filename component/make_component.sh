#!/usr/bin/env bash

readonly JAVA_VERSION="${1}"
if [[ $JAVA_VERSION == 1.8* ]]; then
    JRE="jre/"
elif [[ $JAVA_VERSION == 11* ]]; then
    JRE=""
else
    echo "Unkown java version: $JAVA_VERSION"
    exit 1
fi
readonly COMPONENT_DIR="component_temp_dir"
readonly LANGUAGE_PATH="$COMPONENT_DIR/$JRE/languages/html"
if [[ -f ../native/htmlnative ]]; then
    INCLUDE_SLNATIVE="TRUE"
fi

rm -rf COMPONENT_DIR

mkdir -p "$LANGUAGE_PATH"
cp ../HTMLPrettyPrinter/target/html.jar "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../HTMLPrettyPrinter-Launcher/target/HTML-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../html $LANGUAGE_PATH/bin/
if [[ $INCLUDE_SLNATIVE = "TRUE" ]]; then
    cp ../native/htmlnative $LANGUAGE_PATH/bin/
fi

touch "$LANGUAGE_PATH/native-image.properties"

mkdir -p "$COMPONENT_DIR/META-INF"
{
    echo "Bundle-Name: HTML";
    echo "Bundle-Symbolic-Name: fr.gjouneau.truffle.HTML";
    echo "Bundle-Version: 0.0.1";
    echo 'Bundle-RequireCapability: org.graalvm; filter:="(&(graalvm_version=20.0.0)(os_arch=amd64))"';
    echo "x-GraalVM-Polyglot-Part: True"
} > "$COMPONENT_DIR/META-INF/MANIFEST.MF"

(
cd $COMPONENT_DIR || exit 1
jar cfm ../html-component.jar META-INF/MANIFEST.MF .

echo "bin/html = ../$JRE/languages/html/bin/html" > META-INF/symlinks
if [[ $INCLUDE_SLNATIVE = "TRUE" ]]; then
    echo "bin/htmlnative = ../$JRE/languages/html/bin/htmlnative" >> META-INF/symlinks
fi
jar uf ../html-component.jar META-INF/symlinks

{
    echo "$JRE"'languages/html/bin/html = rwxrwxr-x'
    echo "$JRE"'languages/html/bin/htmlnative = rwxrwxr-x'
} > META-INF/permissions
jar uf ../html-component.jar META-INF/permissions
)
rm -rf $COMPONENT_DIR
