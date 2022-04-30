/*
 * 🤹 common-utils: Common Kotlin utilities made for my personal usage.
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

package gay.floof.utils.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Implements a [ReadOnlyProperty] to provide a simple syntax for constructing slf4j loggers.
 */
class Slf4jDelegate(private val kClass: KClass<*>): ReadOnlyProperty<Any, Logger> {
    override fun getValue(thisRef: Any, property: KProperty<*>): Logger = LoggerFactory.getLogger(kClass.java)
}

/**
 * Create a new [Slf4jDelegate] property.
 * @param cls The class to use
 * @return The read-only property instance
 */
fun <T: KClass<*>> logging(cls: T): Slf4jDelegate = Slf4jDelegate(cls)

/**
 * Create a new [Slf4jDelegate] with [T] as the reified class.
 * @return The read-only property instance
 */
inline fun <reified T> logging(): Slf4jDelegate = logging(T::class)
