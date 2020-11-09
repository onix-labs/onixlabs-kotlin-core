package io.onixlabs.kotlin.core.math

import java.math.BigDecimal

/**
 * Determines whether the specified value represents an integer.
 *
 * @return Returns true if the specified value represents an integer; otherwise, false.
 */
fun BigDecimal.isInteger(): Boolean = rem(BigDecimal.ONE).stripTrailingZeros() == BigDecimal.ZERO