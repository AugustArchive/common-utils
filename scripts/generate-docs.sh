#!/bin/bash

echo "[commons] Updating documentation..."
rm -rf docs
./gradlew dokkaHtmlMultiModule
echo "commons.floof.gay" >> docs/CNAME

echo "[commons] done. :3"
