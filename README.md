# 🤹 Noel's Java/Kotlin Utilities
> *Common Java and Kotlin utilities personalized for myself. Comes with SLF4J, extensions for Kotlin/Koin/Gradle/Exposed, and more!*
> 
> [📜 **Documentation**](https://commons.floofy.dev)

**commons-utils** is a Java and Kotlin library for handling utilities that I use in my projects.

## Utilities
### [commons-java](#)

### [commons-exposed](#)

### [commons-extensions-koin](#)

### [commons-extensions-kotlin](#)

### [commons-gradle](#)

### [commons-slf4j](#)

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
    implementation("dev.floofy.commons:commons-<package>:<VERSION>")
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
    implementation "dev.floofy.commons:utils-<package>:<VERSION>"
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
        <groupId>dev.floofy.commons</groupId>
        <artifactId>commons-{{PACKAGE}}</artifactId>
        <version>{{VERSION}}</version>
        <type>pom</type>
    </dependency>
</dependencies>
```

## License
**common-utils** is released under the **MIT** License, with love by Noel. :3

