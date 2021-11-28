# module gay.floof.utils.gradle
> Gradle plugin for Noel's common utilities

- Provides a Version class that I repeat in all of my Kotlin projects
- Provides the following groups below as a function in `dependencies` to import from the Noel Maven repository.
    - The following groups are available: **floof**, **floofy**, **nino**, and **arisu**.
    - **floof** will return: `gay.floof.{group}:{package}:{version}`
    - **floofy** will return: `dev.floofy.{group}:{package}:{version}`
    - **nino** will return: `sh.nino.{group}:{package}:{version}`
    - **arisu** will return: `land.arisu.{group}:{package}:{version}`

```kt
plugins {
  id("gay.floof.utils.gradle") version "..."
}

// => 1.0.0-rc.0
val current = gay.floof.utils.gradle.Version(1, 0, 0, ReleaseType.RC, 0)

// => 1.0.0
val other = gay.floof.utils.gradle.Version(1, 0, 0)

group = "..."
version = current.string()

repositories {
   mavenCentral()
   maven {
     url = uri("https://maven.floofy.dev/repo/releases")
   }
}

dependencies {
   implementation(floofy("haru", "Haru", "1.3.0"))
   implementation(floof("utils", "collections", "1.0.0"))
   implementation(nino("eri", "core", "1.0.0"))
   implementation(arisu("sdk", "core", "1.0.0"))
}
```
