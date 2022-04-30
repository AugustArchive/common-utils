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
