#!/bin/bash

echo "[commons] Updating documentation..."
rm -rf docs
./gradlew dokkaHtmlMultiModule
rm docs/styles/logo-styles.css && cp assets/logo-styles.css docs/styles/logo-styles.css
echo "commons.floof.gay" >> docs/CNAME

echo "[commons] done. :3"
