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

package gay.floof.gradle.utils.tests

import gay.floof.gradle.utils.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

object VersionTests {
    @Test
    fun `returns 2 dot 0 as the version number`() {
        val version = Version(2, 0, 0)
        assertEquals("$version", "2.0", "Version(2, 0, 0) != 2.0")
    }

    @Test
    fun `returns 2 dot 0 dot 1 dash rc dot 2`() { // returns 2.0.1.-rc.2
        val version = Version(2, 0, 1, 2, ReleaseType.ReleaseCandidate)
        assertEquals("$version", "2.0.1-rc.2", "Version(2, 0, 1, 2, ReleaseType.ReleaseCandidate) != 2.0.1-rc.2")
    }

    @Test
    fun `returns 2 dot 0 dash beta`() { // returns 2.0-beta
        val version = Version(2, 0, 0, 0, ReleaseType.Beta)
        assertEquals("$version", "2.0-beta", "Version(2, 0, 0, 0, ReleaseType.Beta) != 2.0-beta")
    }
}
