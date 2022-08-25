package dev.floofy.utils.java

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Delegate property to handle a [SetOnceGetValue] object.
 */
fun <T: Any> setOnceGetValue(): ReadOnlyProperty<Any?, SetOnceGetValue<T>> = object: ReadOnlyProperty<Any?, SetOnceGetValue<T>> {
    private val setOnceGetValue = SetOnceGetValue<T>()
    override fun getValue(thisRef: Any?, property: KProperty<*>): SetOnceGetValue<T> =
        setOnceGetValue
}
