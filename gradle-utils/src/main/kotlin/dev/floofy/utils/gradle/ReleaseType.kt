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

@file:Suppress("UNUSED")

package dev.floofy.utils.gradle

import java.util.*

/**
 * Returns the release type of specific [Version].
 */
open class ReleaseType(val suffix: String) {
    /**
     * Represents a release candidate release, this is when this project
     * is almost through completion of a new release.
     */
    object ReleaseCandidate: ReleaseType("rc")

    /**
     * Represents a snapshot release, that this is a pre-beta release and
     * bugs will occur.
     */
    object Snapshot: ReleaseType("snapshot")

    /**
     * Represents a "alpha" release, which is still a development build.
     */
    object Alpha: ReleaseType("alpha")

    /**
     * Represents a beta release, this might have some bugs to work out.
     */
    object Beta: ReleaseType("beta")

    /**
     * Default release type for anything.
     */
    object None: ReleaseType("")

    override fun hashCode(): Int = Objects.hash(this)
    override fun equals(other: Any?): Boolean {
        if (other !is ReleaseType) return false

        return suffix == other.suffix
    }
}
