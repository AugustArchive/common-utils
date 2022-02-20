/*
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

@file:JvmName("NoelGradleExtensionsKt")
@file:Suppress("UNUSED")
package gay.floof.gradle.utils

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import java.net.URI

/**
 * Adds a dependency from the `dev.floofy` package.
 * Only modules that require this is:
 *
 * - [Haru](https://haru.floofy.dev)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun DependencyHandler.floofy(group: String, module: String, version: String): Dependency? =
    add("implementation", "dev.floofy.$group:$module:$version")

/**
 * Adds a dependency from the `gay.floof` package.
 * Only modules that require this is:
 *
 * - [commons-slf4j](https://commons.floof.gay)
 * - [Snow](https://snow.floof.dev)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun DependencyHandler.floof(group: String, module: String, version: String): Dependency? =
    add("implementation", "gay.floof.$group:$module:$version")

/**
 * Adds a dependency from the `sh.nino` package.
 * Only modules that require this is:
 *
 * - [Eri](https://eri.nino.sh)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun DependencyHandler.nino(group: String, module: String, version: String): Dependency? =
    add("implementation", "sh.nino.$group:$module:$version")

/**
 * Adds any dependencies from the `org.noelware` package for MPP projects.
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun DependencyHandler.noelware(group: String, module: String, version: String): Dependency? =
    add("implementation", "org.noelware.$group:$module:$version")

/**
 * Adds a dependency from the `dev.floofy` package for MPP projects.
 * Only modules that require this is:
 *
 * - [Haru](https://haru.floofy.dev)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun KotlinDependencyHandler.floofy(group: String, module: String, version: String): Dependency? =
    implementation("gay.floof.$group:$module:$version")

/**
 * Adds a dependency from the `gay.floof` package for MPP projects.
 * Only modules that require this is:
 *
 * - [commons-slf4j](https://commons.floof.gay)
 * - [Snow](https://snow.floof.dev)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun KotlinDependencyHandler.floof(group: String, module: String, version: String): Dependency? =
    implementation("gay.floof.$group:$module:$version")

/**
 * Adds a dependency from the `sh.nino` package for MPP projects.
 * Only modules that require this is:
 *
 * - [Eri](https://eri.nino.sh)
 *
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun KotlinDependencyHandler.nino(group: String, module: String, version: String): Dependency? =
    implementation("gay.floof.$group:$module:$version")

/**
 * Adds any dependencies from the `org.noelware` package for MPP projects.
 * @param group The group to choose from.
 * @param module The module name.
 * @param version The version to use.
 * @return The [Dependency] to use with the `dependencies {}` DSL block.
 */
fun KotlinDependencyHandler.noelware(group: String, module: String, version: String): Dependency? =
    implementation("org.noelware.$group:$module:$version")

/**
 * Adds the Noel repository to this current [RepositoryHandler].
 */
fun RepositoryHandler.noel() {
    maven {
        url = URI.create("https://maven.floofy.dev/repo/releases")
    }
}

/**
 * Adds the Noelware repository to this current [RepositoryHandler].
 */
fun RepositoryHandler.noelware(snapshots: Boolean = false) {
    maven {
        url = URI.create("https://maven.noelware.org${if (snapshots) "/snapshots" else ""}")
    }
}
