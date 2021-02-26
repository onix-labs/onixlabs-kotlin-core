package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.ONE
import io.onixlabs.kotlin.core.ZERO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger
import java.util.*

class DoubleTypeConverterTests {

    @Test
    fun `DoubleTypeConverter should return ONE when Boolean is true`() {

        // Arrange
        val value = true
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return ZERO when Boolean is false`() {

        // Arrange
        val value = false
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ZERO, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a Byte`() {

        // Arrange
        val value = Byte.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a Short`() {

        // Arrange
        val value = Short.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for an Int`() {

        // Arrange
        val value = Int.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a Long`() {

        // Arrange
        val value = Long.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a BigInteger`() {

        // Arrange
        val value = BigInteger.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should throw an exception when a BigInteger overflows`() {

        // Arrange
        val value = Long.MAX_VALUE.toBigInteger().pow(2)
        val converter = DoubleTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a Double`() {

        // Arrange
        val value = Double.ONE
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a String`() {

        // Arrange
        val value = "1"
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE, result)
    }

    @Test
    fun `DoubleTypeConverter should return the expected value for a Char`() {

        // Arrange
        val value = ' '
        val converter = DoubleTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(32.0, result)
    }

    @Test
    fun `DoubleTypeConverter should throw an exception for an unsupported type`() {

        // Arrange
        val value = UUID.randomUUID()
        val converter = DoubleTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals(
            "Illegal type conversion. Cannot convert from 'java.util.UUID' to 'kotlin.Double'.",
            result.message
        )
    }
}
