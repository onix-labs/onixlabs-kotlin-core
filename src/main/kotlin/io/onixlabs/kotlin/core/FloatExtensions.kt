package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Float].
 */
val Float.Companion.ZERO: Float get() = 0.0F

/**
 * Gets the constant ONE of type [Float].
 */
val Float.Companion.ONE: Float get() = 1.0F

/**
 * Determines whether the specified value represents an integer.
 *
 * @return Returns true if the specified value represents an integer; otherwise, false.
 */
fun Float.isInteger(): Boolean = this % Float.ONE == Float.ZERO

/**
 * Converts a [Float] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Float] value.
 */
fun Float.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts a [Float] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Float] value.
 */
fun Float.toBigDecimal(): BigDecimal = BigDecimal.valueOf(toDouble())