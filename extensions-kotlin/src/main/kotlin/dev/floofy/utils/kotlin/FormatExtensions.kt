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

package dev.floofy.utils.kotlin

/**
 * Format this [Long] into a readable byte format.
 */
fun Long.sizeToStr(long: Boolean = false): String = when {
    this > terabytes -> "${toDouble()}${if (long) " terabytes" else "TB"}"
    this > gigabytes -> "${toDouble()}${if (long) " gigabytes" else "GB"}"
    this > megabytes -> "${toDouble()}${if (long) " megabytes" else "MB"}"
    this > kilobytes -> "${toDouble()}${if (long) " kilobytes" else "KB"}"
    else -> "${toDouble()}${if (long) " bytes" else "B"}"
}

/**
 * Converts this [Long] from bytes -> terabytes.
 */
val Long.terabytes: Long
    get() = this * 1099511627776

/**
 * Converts this [Long] from bytes -> gigabytes.
 */
val Long.gigabytes: Long
    get() = this * 1073741824

/**
 * Converts this [Long] from bytes -> megabytes.
 */
val Long.megabytes: Long
    get() = this * 1048576

/**
 * Converts this [Long] from bytes -> kilobytes.
 */
val Long.kilobytes: Long
    get() = this * 1024

/**
 * Returns the humanized time for a [java.lang.Long] instance
 * @credit https://github.com/DV8FromTheWorld/Yui/blob/master/src/main/java/net/dv8tion/discord/commands/UptimeCommand.java#L34
 */
fun Long.humanize(long: Boolean = false, includeMs: Boolean = false): String {
    val months = this / 2592000000L % 12
    val weeks = this / 604800000L % 7
    val days = this / 86400000L % 30
    val hours = this / 3600000L % 24
    val minutes = this / 60000L % 60
    val seconds = this / 1000L % 60

    val str = StringBuilder()
    if (months > 0) str.append(if (long) "$months month${if (months == 1L) "" else "s"}, " else "${months}mo")
    if (weeks > 0) str.append(if (long) "$weeks week${if (weeks == 1L) "" else "s"}, " else "${weeks}w")
    if (days > 0) str.append(if (long) "$days day${if (days == 1L) "" else "s"}, " else "${days}d")
    if (hours > 0) str.append(if (long) "$hours hour${if (hours == 1L) "" else "s"}, " else "${hours}h")
    if (minutes > 0) str.append(if (long) "$minutes minute${if (minutes == 1L) "" else "s"}, " else "${minutes}m")
    if (seconds > 0) str.append(if (long) "$seconds second${if (seconds == 1L) "" else "s"}${if (includeMs && this < 1000) ", " else ""}" else "${seconds}s")

    // Check if this is not over 1000 milliseconds (1 second), so we don't display
    // 1 second, 1893 milliseconds
    if (includeMs && this < 1000) str.append(if (long) "$this millisecond${if (this == 1L) "" else "s"}" else "${this}ms")

    return str.toString()
}
