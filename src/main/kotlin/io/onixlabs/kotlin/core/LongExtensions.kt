package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Long].
 */
val Long.Companion.ZERO: Long get() = 0L

/**
 * Gets the constant ONE of type [Long].
 */
val Long.Companion.ONE: Long get() = 1L

/**
 * Converts a [Long] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Long] value.
 */
fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)

/**
 * Converts a [Long] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Long] value.
 */
fun Long.toBigDecimal(): BigDecimal = BigDecimal.valueOf(this)