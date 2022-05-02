/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
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
package dev.floofy.utils.gradle

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.provider.Property
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler
import java.net.URI

/**
 * Simple infix function to add a property of [T] easily.
 *
 * ```kotlin
 * pom {
 *   name by "noel-common-utils"
 * }
 * ```
 */
infix fun <T> Property<T>.by(value: T) {
    set(value)
}

/**
 * Adds a dependency to the package that is imported from Noel's Maven repository
 * (located at `maven.floofy.dev/repo/[releases|snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Haru](https://docs.floofy.dev/kotlin/haru)
 * - [commons-*](https://docs.floofy.dev/kotlin/commons)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun DependencyHandler.floofy(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = add(type, "dev.floofy.$group:$module:$version")!!

/**
 * Adds a dependency to the package that is imported from Noel's Maven repository
 * (located at `maven.floofy.dev/repo/[releases|snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Towa](https://nino.sh/docs/libraries/towa)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun DependencyHandler.nino(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = add(type, "sh.nino.$group:$module:$version")!!

/**
 * Adds a dependency to the package that is imported from Noelware's Maven repository
 * (located at `maven.noelware.org/[snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Remi](https://docs.noelware.org/libraries/kotlin/remi)
 * - [ktor-routing](https://docs.noelware.org/libraries/kotlin/ktor-routing)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun DependencyHandler.noelware(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = add(type, "org.noelware.$group:$module:$version")!!

/**
 * Adds a dependency to the package that is imported from Noel's Maven repository
 * (located at `maven.floofy.dev/repo/[releases|snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Haru](https://docs.floofy.dev/kotlin/haru)
 * - [commons-*](https://docs.floofy.dev/kotlin/commons)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun KotlinDependencyHandler.floofy(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = when (type) {
    "implementation" -> implementation("dev.floofy.$group:$module:$version")!!
    "api" -> api("dev.floofy.$group:$module:$version")!!
    else -> error("Unknown dependency type: $type")
}

/**
 * Adds a dependency to the package that is imported from Noel's Maven repository
 * (located at `maven.floofy.dev/repo/[releases|snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Towa](https://nino.sh/docs/libraries/towa)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun KotlinDependencyHandler.nino(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = when (type) {
    "implementation" -> implementation("sh.nino.$group:$module:$version")!!
    "api" -> api("sh.nino.$group:$module:$version")!!
    else -> error("Unknown dependency type: $type")
}

/**
 * Adds a dependency to the package that is imported from Noelware's Maven repository
 * (located at `maven.noelware.org/[snapshots]`).
 *
 * The modules that can be imported with this function are:
 * - [Remi](https://docs.noelware.org/libraries/kotlin/remi)
 * - [ktor-routing](https://docs.noelware.org/libraries/kotlin/ktor-routing)
 *
 * @param group The module group to import from.
 * @param module The module name to import from.
 * @param version The version of the module to import from.
 * @param type The dependency type, can be `implementation` or `api`.
 */
fun KotlinDependencyHandler.noelware(
    group: String,
    module: String,
    version: String,
    type: String = "implementation"
): Dependency = when (type) {
    "implementation" -> implementation("org.noelware.$group:$module:$version")!!
    "api" -> api("org.noelware.$group:$module:$version")!!
    else -> error("Unknown dependency type: $type")
}

/**
 * Adds Noel's maven repository to the current [repository handler][RepositoryHandler].
 * @param snapshots If the repository should be configured to use snapshot releases.
 */
fun RepositoryHandler.noel(snapshots: Boolean = false) {
    val suffix = if (snapshots) "snapshots" else "releases"

    maven {
        it.url = URI.create("https://maven.floofy.dev/repo/$suffix")
    }
}

/**
 * Adds the Noelware Maven repository to the current [repository handler][RepositoryHandler].
 * @param snapshots If the repository should be configured to use snapshot releases.
 */
fun RepositoryHandler.noelware(snapshots: Boolean = false) {
    val suffix = if (snapshots) "/snapshots" else ""

    maven {
        it.url = URI.create("https://maven.noelware.org$suffix")
    }
}
