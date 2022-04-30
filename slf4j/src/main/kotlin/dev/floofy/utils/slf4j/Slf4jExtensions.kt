@file:Suppress("UNUSED")
package dev.floofy.utils.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty

/**
 * Constructs a logger from Slf4j's [LoggerFactory] as a readonly property.
 */
inline fun <reified T> logging(): ReadOnlyProperty<Logger, Any?> = ReadOnlyProperty { _, _ ->
    LoggerFactory.getLogger(T::class.java)
}

/**
 * Constructs a logger from Slf4j's [LoggerFactory] as a readonly property.
 */
fun logging(name: String): ReadOnlyProperty<Logger, Any?> = ReadOnlyProperty { _, _ ->
    LoggerFactory.getLogger(name)
}
