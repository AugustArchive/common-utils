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

package dev.floofy.utils.kotlin.threading

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicLong

/**
 * Creates a new [ThreadFactory] object with a specified [name].
 * @param name The name of the thread factory.
 * @param priority The priority to set
 * @param threadGroup The thread group to use.
 * @return a new [ThreadFactory] object.
 */
public fun createThreadFactory(
    name: String,
    priority: Int? = null,
    threadGroup: ThreadGroup = Thread.currentThread().threadGroup
): ThreadFactory = object: ThreadFactory {
    private val id = AtomicLong(0)
    override fun newThread(r: Runnable): Thread {
        val thread = Thread(threadGroup, r, "$name[${id.getAndIncrement()}]")
        if (priority != null) {
            thread.priority = priority
        }

        return thread
    }
}
