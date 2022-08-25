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

package dev.floofy.utils.kotlin.tests

import dev.floofy.utils.kotlin.*
import org.junit.Test
import kotlin.test.assertEquals

class ExtensionsTest {
    @Test
    fun `Long#sizeToStr`() {
        assertEquals(1L.sizeToStr(), "1B")
        assertEquals(12L.sizeToStr(true), "12 bytes")

        assertEquals(1L.gigabytes.sizeToStr(), "1GiB")
        assertEquals(12L.gigabytes.sizeToStr(true), "12 gigabytes")

        assertEquals(1L.terabytes.sizeToStr(), "1TiB")
        assertEquals(12L.terabytes.sizeToStr(true), "12 terabytes")
    }

    @Test
    fun `Long#humanize`() {
        assertEquals(4161800253L.humanize(long = false, true), "1mo6w18d4h3m20s")
        assertEquals(4161800253L.humanize(long = true, true), "1 month, 6 weeks, 18 days, 4 hours, 3 minutes, 20 seconds")
    }
}
