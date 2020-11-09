package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Short].
 */
val Short.Companion.ZERO: Short get() = 0

/**
 * Gets the constant ONE of type [Short].
 */
val Short.Companion.ONE: Short get() = 1

/**
 * Converts a [Short] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Short] value.
 */
fun Short.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts a [Short] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Short] value.
 */
fun Short.toBigDecimal(): BigDecimal = BigDecimal.valueOf(toLong())