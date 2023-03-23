/*
 * 🤹 common-utils: Common Java and Kotlin utilities for Noel's projects ^w^
 * Copyright (c) 2021-2023 Noel Towa <cutie@floofy.dev>
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

import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL
import dev.floofy.utils.gradle.*

plugins {
    id("com.diffplug.spotless")
    id("org.jetbrains.dokka")
    kotlin("jvm")

    `maven-publish`
}

val dokkaOutputDir = "${rootProject.projectDir}/docs"
group = "dev.floofy.commons"
version = VERSION

repositories {
    mavenCentral()
    mavenLocal()
}

spotless {
    // For Kotlin (Gradle), we will need to move the license header
    // as the last step due to https://github.com/diffplug/spotless/issues/1599
    kotlinGradle {
        targetExclude(
            "buildSrc/build/kotlin-dsl/plugins-blocks/extracted/commons-module.gradle.kts",
        )

        endWithNewline()
        encoding("UTF-8")
        target("**/*.gradle.kts")
        ktlint().apply {
            setUseExperimental(true)
            setEditorConfigPath(file("${rootProject.projectDir}/.editorconfig"))
        }

        licenseHeaderFile(file("${rootProject.projectDir}/assets/HEADING"), "(package |@file|import |pluginManagement|plugins|rootProject.name)")
    }
}

tasks {
    wrapper {
        distributionType = ALL
    }

    clean {
        delete(dokkaOutputDir)
    }

    dokkaHtmlMultiModule.configure {
        dependsOn(clean)

        includes.from("README.md")
        outputDirectory.set(file(dokkaOutputDir))
    }
}
