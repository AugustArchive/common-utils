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

### `gay.floof.utils.console`
> :white_check_mark: Available for Kotlin JVM, JS, and Native

- Port of [leeks.js](https://github.com/davidcralph/leeks.js) into Kotlin
- Includes an extension for checking if stdout/stderr is a TTY
- String extensions to provide ansi colors

```kt
import gay.floof.utils.console.*

fun main(args: Array<String>) {
   println("I am now red + bold!".red.bold)
   println(red("this is red") + " " + green("now this is green!"))
   
   if (System.istty()) {
     println("we're in a tty context!")
   } else {
     println(":( we are not in a tty context.")
   }
   
   println(hex(RGB(255, 0, 0), "we are red!"))
   println(rgb(255, 0, 0), "even more red with RGB!"))
}
```

### `gay.floof.utils.collections`
> :warnings: Only available in Kotlin - JVM

- Provides an lru-cache + LinkedList collection utilities

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
    implementation("gay.floof.utils:utils-<package>:<VERSION>")
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
    implementation gay.floof.utils:utils-<package>:<VERSION>"
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
