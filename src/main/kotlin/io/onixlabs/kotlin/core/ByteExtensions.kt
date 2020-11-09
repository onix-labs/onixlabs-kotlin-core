package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Byte].
 */
val Byte.Companion.ZERO: Byte get() = 0

/**
 * Gets the constant ONE of type [Byte].
 */
val Byte.Companion.ONE: Byte get() = 1

/**
 * Converts a [Byte] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Byte] value.
 */
fun Byte.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts a [Byte] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Byte] value.
 */
fun Byte.toBigDecimal(): BigDecimal = BigDecimal.valueOf(toLong())