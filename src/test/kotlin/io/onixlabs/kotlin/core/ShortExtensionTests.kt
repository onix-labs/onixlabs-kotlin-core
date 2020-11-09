package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class ShortExtensionTests {

    @Test
    fun `Short constant ZERO should be the correct value`() {
        assertEquals(0.toShort(), Short.ZERO)
    }

    @Test
    fun `Short constant ONE should be the correct value`() {
        assertEquals(1.toShort(), Short.ONE)
    }

    @Test
    fun `Short_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.toShort()

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Short_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.toShort()

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123), result)
    }
}