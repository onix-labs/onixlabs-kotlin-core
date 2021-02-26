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

import io.onixlabs.kotlin.core.EMPTY
import io.onixlabs.kotlin.core.wrap
import kotlin.reflect.KType
import kotlin.reflect.KTypeProjection
import kotlin.reflect.jvm.jvmErasure

/**
 * Gets the formatted simple name of the type, including any generic type arguments.
 */
val KType.formattedSimpleName: String
    get() = "${jvmErasure.simpleName}${getFormattedArguments(false)}$nullableToken"

/**
 * Gets the formatted qualified name of the type, including any generic type arguments.
 */
val KType.formattedQualifiedName: String
    get() = "${jvmErasure.qualifiedName}${getFormattedArguments(true)}$nullableToken"

/**
 * Gets a nullable token for the specified string, or an empty string if the type is non-nullable.
 */
private val KType.nullableToken: String
    get() = if (isMarkedNullable) "?" else String.EMPTY

/**
 * Gets a formatted list of generic type argument names.
 *
 * @param useQualifiedNames Determines whether to use simple or qualified type names.
 * @return Returns a formatted list of generic type argument names.
 */
private fun KType.getFormattedArguments(useQualifiedNames: Boolean): String = arguments.joinToString {
    when {
        it == KTypeProjection.STAR -> "*"
        useQualifiedNames -> it.type?.jvmErasure?.qualifiedName + it.type?.nullableToken
        else -> it.type?.jvmErasure?.simpleName + it.type?.nullableToken
    }
}.wrap("<", ">")
