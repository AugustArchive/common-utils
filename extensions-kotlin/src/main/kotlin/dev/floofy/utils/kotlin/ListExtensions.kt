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
