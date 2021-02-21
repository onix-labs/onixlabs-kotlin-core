/**
 * Copyright 2020 Matthew Layton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.onixlabs.kotlin.core.reflection

import io.onixlabs.kotlin.core.UNCHECKED_CAST
import io.onixlabs.kotlin.core.UNUSED
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.NoSuchPropertyException
import kotlin.reflect.full.primaryConstructor

/**
 * Provides a shortcut to get the kotlin class for an object instance.
 */
val <T : Any> T.kotlinClass: KClass<T> get() = this.javaClass.kotlin

/**
 * Creates an instance of the specified class.
 *
 * @return Returns an instance of the specified class.
 */
fun <T : Any> KClass<T>.createInstance(): T = getPrimaryConstructor().call()

/**
 * Creates an instance of the specified class.
 *
 * @param args A map of named arguments to use when constructing the object instance.
 * @return Returns an instance of the specified class.
 */
fun <T : Any> KClass<T>.createInstance(args: Map<String, Any?>): T = with(getPrimaryConstructor()) {

    val arguments = parameters
        .associateBy({ it }, { args[it.name] })
        .filterNot { it.key.isOptional && it.value == null }

    callBy(arguments)
}

/**
 * Creates an instance of the specified class.
 *
 * @param args An ordered list of arguments to use when constructing the object instance.
 * @return Returns an instance of the specified class.
 */
@Suppress(UNUSED)
fun <T : Any> KClass<T>.createInstance(args: Array<Any?>): T = getPrimaryConstructor().call(*args)

/**
 * Gets the primary constructor for the specified class.
 *
 * @return Returns a [KFunction] reference to the primary constructor.
 * @throws IllegalStateException if the class has no primary constructor.
 */
fun <T : Any> KClass<T>.getPrimaryConstructor(): KFunction<T> {
    return primaryConstructor ?: throw IllegalStateException("Class '$qualifiedName' has no primary constructor.")
}

/**
 * Gets the immutable properties of the specified class.
 *
 * @return Returns the immutable properties of the specified class.
 */
@Suppress(UNCHECKED_CAST)
fun <T : Any> KClass<T>.getProperties(): List<KProperty1<T, *>> {
    return members.filterIsInstance<KProperty1<*, *>>().map { it as KProperty1<T, *> }
}

/**
 * Gets an immutable property of the specified class by name, or null if no such property exists.
 *
 * @param name The name of the property.
 * @return Returns a [KProperty1] reference to the immutable property.
 */
@Suppress(UNCHECKED_CAST)
fun <T : Any> KClass<T>.getPropertyOrNull(name: String?): KProperty1<T, *>? {
    return members.singleOrNull { it is KProperty1<*, *> && it.name == name } as? KProperty1<T, *>
}

/**
 * Gets an immutable property of the specified class by name.
 *
 * @param name The name of the property.
 * @return Returns a [KProperty1] reference to the immutable property.
 * @throws NoSuchPropertyException if no such property exists for the specified class.
 */
@Suppress(UNUSED, UNCHECKED_CAST)
fun <T : Any> KClass<T>.getProperty(name: String?): KProperty1<T, *> {
    return getPropertyOrNull(name) ?: throw NoSuchPropertyException()
}

/**
 * Gets the mutable properties of the specified class.
 *
 * @return Returns the mutable properties of the specified class.
 */
@Suppress(UNUSED, UNCHECKED_CAST)
fun <T : Any> KClass<T>.getMutableProperties(): Iterable<KMutableProperty1<T, *>> {
    return members.filterIsInstance<KMutableProperty1<*, *>>().map { it as KMutableProperty1<T, *> }
}

/**
 * Gets a mutable property of the specified class by name, or null if no such property exists.
 *
 * @param name The name of the property.
 * @return Returns a [KProperty1] reference to the mutable property.
 */
@Suppress(UNCHECKED_CAST)
fun <T : Any> KClass<T>.getMutablePropertyOrNull(name: String?): KMutableProperty1<T, *>? {
    return members.singleOrNull { it is KMutableProperty1<*, *> && it.name == name } as? KMutableProperty1<T, *>
}

/**
 * Gets a mutable property of the specified class by name.
 *
 * @param name The name of the property.
 * @return Returns a [KProperty1] reference to the mutable property.
 * @throws NoSuchPropertyException if no such property exists for the specified class.
 */
@Suppress(UNUSED, UNCHECKED_CAST)
fun <T : Any> KClass<T>.getMutableProperty(name: String?): KMutableProperty1<T, *> {
    return getMutablePropertyOrNull(name) ?: throw NoSuchPropertyException()
}
