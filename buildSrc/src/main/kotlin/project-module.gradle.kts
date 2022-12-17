/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
 * Copyright (c) 2021-2022 Noel <cutie@floofy.dev>
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

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import dev.floofy.utils.gradle.*

plugins {
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
    kotlin("jvm")
    java
}

group = "dev.floofy.commons"
version = VERSION

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    // Kotlin libraries
    implementation(kotlin("stdlib", "1.7.22"))
}

kotlin {
    explicitApi()
}

spotless {
    java {
        trimTrailingWhitespace()
        licenseHeaderFile("${rootProject.projectDir}/assets/HEADING")
        palantirJavaFormat()
        endWithNewline()
    }

    kotlin {
        trimTrailingWhitespace()
        licenseHeaderFile("${rootProject.projectDir}/assets/HEADING")
        endWithNewline()

        // We can't use the .editorconfig file, so we'll have to specify it here
        // issue: https://github.com/diffplug/spotless/issues/142
        ktlint()
            .setUseExperimental(true)
            .editorConfigOverride(mapOf(
                "indent_size" to "4",
                "ktlint_disabled_rules" to "no-wildcard-imports,colon-spacing,annotation-spacing,filename",
                "ij_kotlin_allow_trailing_comma" to "false",
                "ktlint_code_style" to "official",
                "experimental:fun-keyword-spacing" to "true",
                "experimental:unnecessary-parentheses-before-trailing-lambda" to "true",
                "no-unit-return" to "true",
                "no-consecutive-blank-lines" to "true"
            ))
    }
}

java {
    sourceCompatibility = JAVA_VERSION
    targetCompatibility = JAVA_VERSION
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JAVA_VERSION.toString()
        kotlinOptions.javaParameters = true
        kotlinOptions.freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn")
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    dokkaHtml {
        dokkaSourceSets {
            configureEach {
                platform.set(org.jetbrains.dokka.Platform.jvm)
                jdkVersion.set(17)

                sourceLink {
                    localDirectory.set(file("src/main/kotlin"))
                    remoteUrl.set(uri("https://github.com/auguwu/common-utils/tree/master/${project.name}/src/main/kotlin").toURL())
                    remoteLineSuffix.set("#L")
                }
            }
        }
    }
}
