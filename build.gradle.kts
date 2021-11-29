/**
 * Copyright (c) 2021 Noel <cutie@floofy.dev>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import org.jetbrains.dokka.base.DokkaBaseConfiguration
import gay.floof.utils.gradle.configurePom
import org.jetbrains.dokka.base.DokkaBase
import java.util.Properties

buildscript {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:6.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.6.0")
        classpath("org.jetbrains.dokka:dokka-base:1.6.0")
    }
}

plugins {
    id("com.gradle.plugin-publish") version "0.16.0"
    id("com.diffplug.spotless") version "6.0.0"
    id("org.jetbrains.dokka") version "1.6.0"
    kotlin("jvm") version "1.6.0"
    `java-gradle-plugin`
    `maven-publish`
}

group = "gay.floof"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

// Setup root project tasks
tasks {
    val dokkaOutput = "${rootProject.projectDir}/docs"

    clean {
        delete(dokkaOutput)
    }
}

subprojects {
    // Define project metadata
    group = "gay.floof.utils"
    version = rootProject.version as String

    // Define plugins from root project
    apply(plugin = "kotlin")
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "com.diffplug.spotless")

    // Check if we aren't in the gradle plugin project
    if (this.name == "gradle-plugin") {
        apply(plugin = "java-gradle-plugin")
        apply(plugin = "com.gradle.plugin-publish")
    }

    // Setup Spotless
    spotless {
        kotlin {
            trimTrailingWhitespace()
            endWithNewline()
            licenseHeaderFile("${rootProject.projectDir}/assets/HEADING")

            // We can't use the .editorconfig file, so we'll have to specify it here
            // issue: https://github.com/diffplug/spotless/issues/142
            // ktlint 0.35.0 (default for Spotless) doesn't support trailing commas
            ktlint("0.43.0")
                .userData(mapOf(
                    "no-consecutive-blank-lines" to "true",
                    "no-unit-return" to "true",
                    "disabled_rules" to "no-wildcard-imports,colon-spacing",
                    "indent_size" to "4"
                ))
        }
    }

    // Add repositories and dependencies for all subprojects
    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
    }

    dependencies {
        implementation(kotlin("stdlib", "1.5.31"))
    }

    // Setup Dokka tasks
    tasks.dokkaHtml.configure {
        outputDirectory.set(file("${rootProject.projectDir}/docs"))
        dokkaSourceSets {
            configureEach {
                platform.set(org.jetbrains.dokka.Platform.jvm)
                sourceLink {
                    localDirectory.set(file("src/main/kotlin"))
                    remoteUrl.set(uri("https://github.com/auguwu/common-utils/tree/master/${project.name}/src/main/kotlin").toURL())
                    remoteLineSuffix.set("#L")
                }

                jdkVersion.set(16)
            }
        }
    }

    // In order to use @OptIn, we need to add the compiler flag
    tasks.compileKotlin.configure {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
        kotlinOptions.javaParameters = true
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }

    if (this.name == "gradle-plugin") {
        pluginBundle {
            website = "https://commons.floof.gay"
            vcsUrl = "https://github.com/auguwu/common-utils"
            tags = listOf("utilities", "utils", "commons")
        }

        gradlePlugin {
            plugins {
                create("gay.floof.noelUtils") {
                    id = "gay.floof.gradle"
                    displayName = "Noel's Common Gradle Utilities"
                    description = "Common utilities Noel uses for his Gradle projects."
                    implementationClass = "gay.floof.gradle.utils.GradleUtilPlugin"
                }
            }
        }
    } else {
        // Setup publishing to post to maven.floofy.dev
        val publishingProps = try {
            Properties().apply { load(file("${rootProject.projectDir}/gradle/publishing.properties").reader()) }
        } catch(e: Exception) {
            Properties()
        }

        val sourcesJar by tasks.registering(Jar::class) {
            archiveClassifier.set("sources")
            from(sourceSets.main.get().allSource)
        }

        val dokkaJar by tasks.registering(Jar::class) {
            group = JavaBasePlugin.DOCUMENTATION_GROUP
            description = "Assemble Kotlin documentation with Dokka"

            archiveClassifier.set("javadoc")
            from(tasks.dokkaHtml)
            dependsOn(tasks.dokkaHtml)
        }

        publishing {
            publications {
                create<MavenPublication>("Commons${project.name.replaceFirstChar { it.toUpperCase() }}") {
                    from(components["kotlin"])

                    groupId = "gay.floof.commons"
                    artifactId = "commons-${project.name}"
                    version = project.version as String

                    artifact(sourcesJar.get())
                    artifact(dokkaJar.get())

                    pom {
                        configurePom(project.name)
                    }
                }
            }

            repositories {
                maven(url = "s3://maven.floofy.dev/repo/releases") {
                    credentials(AwsCredentials::class.java) {
                        accessKey = publishingProps.getProperty("s3.accessKey") ?: ""
                        secretKey = publishingProps.getProperty("s3.secretKey") ?: ""
                    }
                }
            }
        }
    }
}

tasks.dokkaHtmlMultiModule.configure {
    outputDirectory.set(file("${project.projectDir}/docs"))
}

inline fun String.replaceFirstChar(transform: (Char) -> Char): String = if (isNotEmpty()) transform(this[0]).toString() + substring(1) else this
