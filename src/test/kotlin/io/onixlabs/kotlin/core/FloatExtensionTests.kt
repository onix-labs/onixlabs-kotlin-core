package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class FloatExtensionTests {

    @Test
    fun `Float constant ZERO should be the correct value`() {
        assertEquals(0.0F, Float.ZERO)
    }

    @Test
    fun `Float constant ONE should be the correct value`() {
        assertEquals(1.0F, Float.ONE)
    }

    @Test
    fun `Float_isInteger should return true when the value is an integer`() {

        // Arrange
        val value = 123.0F

        // Act
        val result = value.isInteger()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Float_isInteger should return false when the value is not an integer`() {

        // Arrange
        val value = 123.456F

        // Act
        val result = value.isInteger()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `Float_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.0F

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Float_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.0F

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123.0), result)
    }
}