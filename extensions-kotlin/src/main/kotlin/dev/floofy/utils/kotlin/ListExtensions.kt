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

package dev.floofy.utils.kotlin

/**
 * Returns a [Pair] from a [List] object which the first item is from the
 * [#first()][List.first] function, and the second pair is the remaining arguments.
 */
fun <T> List<T>.firstThenRest(): Pair<T, List<T>> = Pair(first(), drop(1))

/**
 * Returns true if every element appears to be true from the [predicate] closure, otherwise
 * it returns false.
 *
 * @param predicate The predicate closure to call.
 */
fun <T> Iterable<T>.every(predicate: (T) -> Boolean): Boolean {
    for (item in this) {
        if (!predicate(item)) return false
    }

    return true
}

/**
 * Returns the index from any elements that appears true from the [predicate] closure,
 * otherwise, it returns false.
 *
 * @param predicate The predicate closure to call
 * @return The remaining index that the [predicate] closure returned true. Otherwise,
 *         it'll return -1 if the remaining elements didn't match the [predicate] closure.
 */
fun <T> Iterable<T>.findIndex(predicate: (T) -> Boolean): Int {
    for ((i, item) in this.withIndex()) {
        if (predicate(item)) return i
    }

    return -1
}
