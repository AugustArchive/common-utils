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

rootProject.name = "commons-utils"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
    id("com.gradle.enterprise") version "3.13"
}

include(
    ":bom",
    ":extensions-koin",
    ":extensions-kotlin",
    ":gradle-utils",
    ":java-utils",
    ":slf4j",
)

val buildScanServer = System.getProperty("dev.floofy.gradle.build-scan-server", "") ?: ""
gradleEnterprise {
    buildScan {
        if (buildScanServer.isNotEmpty()) {
            server = buildScanServer
            publishAlways()
        } else {
            termsOfServiceUrl = "https://gradle.com/terms-of-service"
            termsOfServiceAgree = "yes"
        }

        obfuscation {
            ipAddresses { listOf("0.0.0.0") }
            hostname { "[redacted]" }
            username { "[redacted]" }
        }
    }
}
