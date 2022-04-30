@file:Suppress("UNUSED")
package dev.floofy.utils.koin

import org.koin.core.context.GlobalContext
import kotlin.properties.ReadOnlyProperty

/**
 * Readonly property to quickly get a reference of [T].
 */
inline fun <reified T> inject(): ReadOnlyProperty<T, Any?> = ReadOnlyProperty { _, _ ->
    GlobalContext.retrieve()
}

/**
 * Simple method to return an object as [T] from the current Koin application
 */
inline fun <reified T> GlobalContext.retrieve(): T = get().get()

/**
 * Simple method to return an object as [T] from the current Koin application or
 * `null` if it was never registered.
 */
inline fun <reified T> GlobalContext.retrieveOrNull(): T? = get().getOrNull()

/**
 * Returns a list of objects as [T] from the current Koin application.
 */
inline fun <reified T> GlobalContext.retrieveAll(): List<T> = get().getAll()
