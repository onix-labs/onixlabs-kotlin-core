package io.onixlabs.kotlin.core.reflection

import io.onixlabs.kotlin.core.EMPTY
import io.onixlabs.kotlin.core.wrap
import kotlin.reflect.KType
import kotlin.reflect.KTypeProjection
import kotlin.reflect.jvm.jvmErasure

/**
 * Gets the formatted simple name of the type, including any generic type arguments.
 */
val KType.name: String get() = "${jvmErasure.simpleName}${getFormattedArguments(false)}$nullableToken"

/**
 * Gets the formatted qualified name of the type, including any generic type arguments.
 */
val KType.fullName: String get() = "${jvmErasure.qualifiedName}${getFormattedArguments(true)}$nullableToken"

/**
 * Gets a nullable token for the specified string, or an empty string if the type is non-nullable.
 */
private val KType.nullableToken: String get() = if (isMarkedNullable) "?" else String.EMPTY

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