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

package dev.floofy.utils.java

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate property to handle a [SetOnce] object.
 */
public fun <T: Any> setOnceGetValue(): ReadWriteProperty<Any?, T?> = object: ReadWriteProperty<Any?, T?> {
    private val setOnceGetValue = SetOnce<T>()
    override fun getValue(thisRef: Any?, property: KProperty<*>): T? = setOnceGetValue.valueOrNull
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        if (value == null) throw IllegalStateException("Can't allow null when using `<value> = null`.")
        setOnceGetValue.value = value
    }
}
