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

package dev.floofy.utils.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty

/**
 * Constructs a logger from Slf4j's [LoggerFactory] as a readonly property.
 */
public inline fun <reified T> logging(): ReadOnlyProperty<Any?, Logger> = ReadOnlyProperty { _, _ ->
    LoggerFactory.getLogger(T::class.java)
}

/**
 * Constructs a logger from Slf4j's [LoggerFactory] as a readonly property.
 */
public fun logging(name: String): ReadOnlyProperty<Any?, Logger> = ReadOnlyProperty { _, _ ->
    LoggerFactory.getLogger(name)
}
