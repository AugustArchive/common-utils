@file:Suppress("UNUSED")
package dev.floofy.utils.kotlin

import kotlin.reflect.KClass

/**
 * Calls the [body] function if [T] was not null.
 * @param body The body function to call if [T] was not null.
 * @return The result from the [body] as [U].
 */
fun <T, U> T?.ifNotNull(body: (T) -> U): U? = if (this != null) body(this) else null

/**
 * Calls the [body] function if [T] was null.
 * @param body The body function to call if [T] was null.
 * @return The result from [body] as [U].
 */
fun <T, U> T?.ifNull(body: T?.() -> U): U? = if (this == null) body() else null

/**
 * Tries a function method on [T], returns `null` if the exception was the instance
 * of [E].
 *
 * @param catchOn The exception to catch on.
 * @param body The body function to call.
 * @return The result from the [body] function as [U].
 */
fun <T, U, E: Throwable> T.tryCatch(catchOn: KClass<E>, body: (T) -> U): U? = try {
    body(this)
} catch (e: Throwable) {
    if (catchOn.isInstance(e)) {
        null
    } else {
        throw e
    }
}
