package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class ByteExtensionTests {

    @Test
    fun `Byte constant ZERO should be the correct value`() {
        assertEquals(0.toByte(), Byte.ZERO)
    }

    @Test
    fun `Byte constant ONE should be the correct value`() {
        assertEquals(1.toByte(), Byte.ONE)
    }

    @Test
    fun `Byte_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.toByte()

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Byte_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.toByte()

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123), result)
    }
}