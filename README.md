# 🤹 common-utils
> Common Kotlin utilities made for my personal usage, comes with SLF4J utilities, common extensions, ansi-colours, common Gradle utilities, and more.
>
> [📜 **Documentation**](https://commons.floof.gay)

## Utilities
### `gay.floof.utils.slf4j`
> :warning: Only available for Kotlin - JVM.

- Comes with a read-only delegate property for constructing SLF4J loggers:

```kt
import gay.floof.utils.slf4j.*

object Something {
   val logger by logging<Something>() // => org.slf4j.Logger
}
```

### `gay.floof.utils.gradle`
- Provides an extension for **noel()** in a `repositories` block.
- Provides a Version class that I repeat in all of my Kotlin projects
- Provides the following groups below as a function in `dependencies` to import from the Noel Maven repository.
   - The following groups are available: **floof**, **floofy**, **nino**, and **arisu**.
   - **floof** will return: `gay.floof.{group}:{package}:{version}`
   - **floofy** will return: `dev.floofy.{group}:{package}:{version}`
   - **nino** will return: `sh.nino.{group}:{package}:{version}`
   - **arisu** will return: `land.arisu.{group}:{package}:{version}`

## Installation
### Gradle
#### Kotlin DSL
```kotlin
repositories {
    maven {
        url = uri("https://maven.floofy.dev/repo/releases")
    }
}

dependencies {
    implementation("gay.floof.utils:commons-<package>:<VERSION>")
}
```

#### Groovy DSL
```groovy
repositories {
    maven {
        url "https://maven.floofy.dev/repo/releases"
    }
}

dependencies {
    implementation "gay.floof.utils:utils-<package>:<VERSION>"
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>noel-maven</id>
        <url>https://maven.floofy.dev/repo/releases</url>
    </repository>
</repositories>
```

```xml
<dependencies>
    <dependency>
        <groupId>gay.floof.utils</groupId>
        <artifactId>utils-{{PACKAGE}}</artifactId>
        <version>{{VERSION}}</version>
        <type>pom</type>
    </dependency>
</dependencies>
```

## License
**common-utils** is released under the **GPL-3.0** License.
