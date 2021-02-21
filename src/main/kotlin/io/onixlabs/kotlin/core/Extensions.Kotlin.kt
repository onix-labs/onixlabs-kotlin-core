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

package io.onixlabs.kotlin.core

/**
 * Iterates over the specified collection of elements.
 *
 * @param T The underlying type of the collection of elements.
 * @param items The collection of elements to iterate over.
 * @param action The action to perform for each element in the collection.
 */
fun <T> forEach(vararg items: T, action: (T) -> Unit) = items.forEach(action)
