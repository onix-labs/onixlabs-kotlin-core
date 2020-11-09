package io.onixlabs.kotlin.core

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Int].
 */
val Int.Companion.ZERO: Int get() = 0

/**
 * Gets the constant ONE of type [Int].
 */
val Int.Companion.ONE: Int get() = 1

/**
 * Converts an [Int] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Int] value.
 */
fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts an [Int] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Int] value.
 */
fun Int.toBigDecimal(): BigDecimal = BigDecimal.valueOf(toLong())