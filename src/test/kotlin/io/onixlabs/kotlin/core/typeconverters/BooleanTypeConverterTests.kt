package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.ONE
import io.onixlabs.kotlin.core.ZERO
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class BooleanTypeConverterTests {

    @Test
    fun `BooleanTypeConverter should return the expected value for a Boolean value true`() {

        // Arrange
        val value = true
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a Boolean value false`() {

        // Arrange
        val value = false
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a Numeric value ONE`() {

        // Arrange
        val value = Int.ONE
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a Numeric value ZERO`() {

        // Arrange
        val value = Int.ZERO
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a String value true`() {

        // Arrange
        val value = "true"
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a String value false`() {

        // Arrange
        val value = "false"
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a Char value Y`() {

        // Arrange
        val value = 'Y'
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BooleanTypeConverter should return the expected value for a Char value N`() {

        // Arrange
        val value = 'N'
        val converter = BooleanTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `BooleanTypeConverter should throw an exception for an unsupported type`() {

        // Arrange
        val value = UUID.randomUUID()
        val converter = BooleanTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals(
            "Illegal type conversion. Cannot convert from 'java.util.UUID' to 'kotlin.Boolean'.",
            result.message
        )
    }
}
