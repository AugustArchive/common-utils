/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
 * Copyright (c) 2021-2023 Noel <cutie@floofy.dev>
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

package dev.floofy.utils.koin

import org.koin.core.context.GlobalContext
import kotlin.properties.ReadOnlyProperty

/**
 * Readonly property to quickly get a reference of [T].
 */
public inline fun <reified T> inject(): ReadOnlyProperty<Any?, T> = ReadOnlyProperty { _, _ ->
    GlobalContext.retrieve()
}

/**
 * Readonly property to get a reference of [T] or null if it wasn't found in the Koin application.
 */
public inline fun <reified T> injectOrNull(): ReadOnlyProperty<Any?, T?> = ReadOnlyProperty { _, _ ->
    GlobalContext.retrieveOrNull()
}

/**
 * Simple method to return an object as [T] from the current Koin application
 */
public inline fun <reified T> GlobalContext.retrieve(): T = get().get()

/**
 * Simple method to return an object as [T] from the current Koin application or
 * `null` if it was never registered.
 */
public inline fun <reified T> GlobalContext.retrieveOrNull(): T? = get().getOrNull()

/**
 * Returns a list of objects as [T] from the current Koin application.
 */
public inline fun <reified T> GlobalContext.retrieveAll(): List<T> = get().getAll()
