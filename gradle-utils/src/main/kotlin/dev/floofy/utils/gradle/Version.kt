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

package dev.floofy.utils.gradle

import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Represents a simple version class to use for versioning.
 * @param major The major version.
 * @param minor The minor version.
 * @param patch The patch version.
 * @param build The build version, this is only needed if the [ReleaseType] is not `None`.
 * @param release The release type to use for the finalized result. Defaults to [ReleaseType.None].
 */
class Version(
    private val major: Int,
    private val minor: Int,
    private val patch: Int,
    private val build: Int = 0,
    private val release: ReleaseType = ReleaseType.None
) {
    override fun toString(): String = buildString {
        append("$major.$minor")
        if (patch != 0) {
            append(".$patch")
        }

        if (release != ReleaseType.None) {
            append("-${release.suffix}")
        }

        if (build != 0 && release != ReleaseType.None) {
            append(".$build")
        }
    }

    /**
     * Returns the commit sha if the project is in a Git repository. Returns `null`
     * if a [IOException] had occurred.
     */
    fun getGitCommit(): String? = try {
        val parts = "git rev-parse --short=8 HEAD".split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
            .directory(File("."))
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        proc.waitFor(60, TimeUnit.SECONDS)
        proc.inputStream.bufferedReader().readText()
    } catch (e: IOException) {
        null
    }
}
