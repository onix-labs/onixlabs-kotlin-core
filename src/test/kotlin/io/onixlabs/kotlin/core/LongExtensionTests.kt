package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class LongExtensionTests {

    @Test
    fun `Long constant ZERO should be the correct value`() {
        assertEquals(0L, Long.ZERO)
    }

    @Test
    fun `Long constant ONE should be the correct value`() {
        assertEquals(1L, Long.ONE)
    }

    @Test
    fun `Long_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123L

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Long_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123L

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123), result)
    }
}