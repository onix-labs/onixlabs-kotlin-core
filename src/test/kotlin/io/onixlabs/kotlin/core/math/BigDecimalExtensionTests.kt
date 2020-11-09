package io.onixlabs.kotlin.core.math

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BigDecimalExtensionTests {

    @Test
    fun `BigDecimal_isInteger should return true when the value is an integer`() {

        // Arrange
        val value = 123.toBigDecimal()

        // Act
        val result = value.isInteger()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BigDecimal_isInteger should return false when the value is not an integer`() {

        // Arrange
        val value = (123.456).toBigDecimal()

        // Act
        val result = value.isInteger()

        // Assert
        assertFalse(result)
    }
}