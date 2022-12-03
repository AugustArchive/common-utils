# 🤹 Noel's Java/Kotlin Utilities
> *Common Java and Kotlin utilities personalized for myself. Comes with SLF4J, extensions for Kotlin/Koin/Gradle/Exposed, and more!*
> 
> [📜 **Documentation**](https://commons.floofy.dev)

**commons-utils** is a Java and Kotlin library for handling utilities that I use in my projects.

## Utilities
### [commons-java-utils](https://commons.floofy.dev/java-utils/index.html)
**java-utils** adds some additional utilities for Java-related programming.

#### [SetOnce<T>](https://commons.floofy.dev/java-utils/dev.floofy.utils.java/-set-once/index.html)
The **SetOnce** class lets an object be initialized once and can't be ever set again. It's useful if you wish to have values in your
Java classes to be initialized only once and never again when your application is running.

```java
private static final SetOnce<String> someString = new SetOnce<>();

someString.getValue();        // => throws IllegalStateException
someString.getValueOrNull();  // => `null`
someString.wasSet();          // => false
someString.setValue("hello"); // => void
someString.getValue();        // => "hello"
someString.getValueOrNull();  // => "hello"
someString.wasSet();          // => true
someString.setValue("world"); // => void
someString.getValue();        // => "hello"
```

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
    implementation("dev.floofy.commons:<package>:<VERSION>")
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
    implementation "dev.floofy.commons:<package>:<VERSION>"
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
        <artifactId>{{PACKAGE}}</artifactId>
        <version>{{VERSION}}</version>
        <type>pom</type>
    </dependency>
</dependencies>
```

## License
**common-utils** is released under the **MIT** License, with love by Noel. :3
