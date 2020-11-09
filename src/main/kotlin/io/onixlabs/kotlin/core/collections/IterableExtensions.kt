package io.onixlabs.kotlin.core.collections

/**
 * Determines whether the number of elements that satisfy the specified predicate match the expected count.
 *
 * @param T The underlying type of the iterable elements.
 * @param count The expected number of elements.
 * @param predicate The predicate against which to evaluate the elements.
 * @return Returns true if the elements that satisfy the specified predicate match the expected count; otherwise, false.
 */
fun <T> Iterable<T>.hasCount(count: Int, predicate: (T) -> Boolean = { true }): Boolean {
    return count(predicate) == count
}

/**
 * Determines whether the iterable is empty.
 *
 * @param T The underlying type of the iterable elements.
 * @return Returns true if the iterable is empty; otherwise, false.
 */
fun <T> Iterable<T>.isEmpty(): Boolean {
    return count() == 0
}

/**
 * Determines whether the iterable is not empty.
 *
 * @param T The underlying type of the iterable elements.
 * @return Returns true if the iterable is not empty; otherwise, false.
 */
fun <T> Iterable<T>.isNotEmpty(): Boolean {
    return !isEmpty()
}

/**
 * Performs an ordered check to determine whether the content in two iterable collections is identical.
 *
 * @param other The other iterable collection to compare.
 * @return Returns true if the content in each collection is equal and ordered; otherwise, false.
 */
fun <T> Iterable<T>.orderedContentEquals(other: Iterable<T>): Boolean {
    return this == other
}

/**
 * Performs an unordered check to determine whether the content in two iterable collections is identical.
 *
 * @param other The other iterable collection to compare.
 * @return Returns true if the content in each collection is equal regardless of order; otherwise, false.
 */
fun <T> Iterable<T>.unorderedContentEquals(other: Iterable<T>): Boolean {
    return ((this subtract other) union (other subtract this)).isEmpty()
}