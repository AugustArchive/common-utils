# 🤹 common-utils
> Common Kotlin utilities made for my personal usage, comes with SLF4J utilities, common extensions, ansi-colours, common Gradle utilities, and more.
>
> [📜 **Documentation**](https://commons.floof.gay)

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
