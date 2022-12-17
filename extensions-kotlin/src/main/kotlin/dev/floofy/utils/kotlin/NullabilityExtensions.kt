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

import kotlin.reflect.KClass

/**
 * Calls the [body] function if [T] was not null.
 * @param body The body function to call if [T] was not null.
 * @return The result from the [body] as [U].
 */
public fun <T, U> T?.ifNotNull(body: T.() -> U): U? = if (this != null) body() else null

/**
 * Calls the [body] function if [T] was null.
 * @param body The body function to call if [T] was null.
 * @return The result from [body] as [U].
 */
public fun <T, U> T?.ifNull(body: () -> U): U? = if (this == null) body() else null

/**
 * Tries a function method on [T], returns `null` if the exception was the instance
 * of [E].
 *
 * @param catchOn The exception to catch on.
 * @param body The body function to call.
 * @return The result from the [body] function as [U].
 */
@Deprecated("Will be removed in v2.5")
public fun <T, U, E: Throwable> T.tryCatch(catchOn: KClass<E>, body: T.() -> U): U? = try {
    body()
} catch (e: Throwable) {
    if (catchOn.isInstance(e)) {
        null
    } else {
        throw e
    }
}

/**
 * Tries a function method from [T], returns `null` if the exception was an instance of [E],
 * if not, the exception will just throw on its own.
 *
 * @param body The body function to call.
 * @return The result from the [body] function as [U].
 */
@Deprecated("Will be removed in v2.5", ReplaceWith("tryCatch(E::class, body)"))
public inline fun <reified E: Throwable, T, U> T.tryCatch(noinline body: T.() -> U): U? = tryCatch(E::class, body)
