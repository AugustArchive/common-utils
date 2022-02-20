# powershell > cmd shell u cannot make this shit up LMAO

Write-Output "[commons] Updating documentation..."
Remove-Item -Recurse -Force docs
.\gradlew dokkaHtmlMultiModule
Remove-item docs/styles/logo-styles.css
Copy-Item assets/logo-styles.css docs/styles/logo-styles.css
echo "commons.floof.gay" >> docs/CNAME

Write-Output "[commons] done!"
