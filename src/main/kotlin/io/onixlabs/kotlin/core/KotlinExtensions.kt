package io.onixlabs.kotlin.core

/**
 * Iterates over the specified collection of elements.
 *
 * @param T The underlying type of the collection of elements.
 * @param items The collection of elements to iterate over.
 * @param action The action to perform for each element in the collection.
 */
fun <T> forEach(vararg items: T, action: (T) -> Unit) = items.forEach(action)