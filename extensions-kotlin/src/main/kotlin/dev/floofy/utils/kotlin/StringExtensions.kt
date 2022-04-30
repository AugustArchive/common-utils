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

@file:Suppress("UNUSED")
package dev.floofy.utils.kotlin

import java.util.*

/**
 * Concat a string if it's over [textLen].
 * @param textLen The length of the text to concat
 * @return this [String] concat-ed if it was over [textLen].
 */
fun String.ellipsis(textLen: Int = 1995): String = if (length > textLen) {
    "${slice(0..textLen)}..."
} else {
    this
}

/**
 * Upper cases the first letter of this [String]
 */
fun String.titleCase(): String {
    if (isNotEmpty()) {
        val first = this[0]
        if (first.isLowerCase()) {
            return buildString {
                val titleChar = first.titlecaseChar()
                if (titleChar != first.uppercaseChar()) {
                    append(titleChar)
                } else {
                    append(this@titleCase.substring(0, 1).uppercase(Locale.getDefault()))
                }

                append(this@titleCase.substring(1))
            }
        }
    }

    return this
}
