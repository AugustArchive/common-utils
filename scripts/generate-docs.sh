#!/bin/bash

echo "[commons] Updating documentation..."
rm -rf docs
./gradlew dokkaHtmlMultiModule
echo "commons.floofy.dev" >> docs/CNAME

echo "[commons] done. :3"
