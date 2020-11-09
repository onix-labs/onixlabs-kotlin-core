package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class DoubleExtensionTests {

    @Test
    fun `Double constant ZERO should be the correct value`() {
        assertEquals(0.0, Double.ZERO)
    }

    @Test
    fun `Double constant ONE should be the correct value`() {
        assertEquals(1.0, Double.ONE)
    }

    @Test
    fun `Double_isInteger should return true when the value is an integer`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.isInteger()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Double_isInteger should return false when the value is not an integer`() {

        // Arrange
        val value = 123.456

        // Act
        val result = value.isInteger()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `Double_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Double_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123.0), result)
    }
}