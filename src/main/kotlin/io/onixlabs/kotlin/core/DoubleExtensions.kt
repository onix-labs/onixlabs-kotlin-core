package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Double].
 */
val Double.Companion.ZERO: Double get() = 0.0

/**
 * Gets the constant ONE of type [Double].
 */
val Double.Companion.ONE: Double get() = 1.0

/**
 * Determines whether the specified value represents an integer.
 *
 * @return Returns true if the specified value represents an integer; otherwise, false.
 */
fun Double.isInteger(): Boolean = this % Double.ONE == Double.ZERO

/**
 * Converts a [Double] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Double] value.
 */
fun Double.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts a [Double] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Double] value.
 */
fun Double.toBigDecimal(): BigDecimal = BigDecimal.valueOf(this)