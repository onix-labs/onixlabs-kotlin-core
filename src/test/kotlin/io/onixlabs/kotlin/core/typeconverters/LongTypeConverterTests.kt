package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.ONE
import io.onixlabs.kotlin.core.ZERO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

class LongTypeConverterTests {

    @Test
    fun `LongTypeConverter should return ONE when Boolean is true`() {

        // Arrange
        val value = true
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return ZERO when Boolean is false`() {

        // Arrange
        val value = false
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ZERO, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Byte`() {

        // Arrange
        val value = Byte.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Short`() {

        // Arrange
        val value = Short.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for an Int`() {

        // Arrange
        val value = Int.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Long`() {

        // Arrange
        val value = Long.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a BigInteger`() {

        // Arrange
        val value = BigInteger.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a BigInteger overflows`() {

        // Arrange
        val value = Long.MAX_VALUE.toBigInteger().pow(2)
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Float`() {

        // Arrange
        val value = Float.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a Float loses precision`() {

        // Arrange
        val value = 123.456F
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Double`() {

        // Arrange
        val value = Double.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a Double overflows`() {

        // Arrange
        val value = Double.MAX_VALUE
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a Double loses precision`() {

        // Arrange
        val value = 123.456
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a BigDecimal`() {

        // Arrange
        val value = BigDecimal.ONE
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a BigDecimal overflows`() {

        // Arrange
        val value = Long.MAX_VALUE.toBigDecimal().pow(2)
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `LongTypeConverter should throw an exception when a BigDecimal loses precision`() {

        // Arrange
        val value = (123.456).toBigDecimal()
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a String`() {

        // Arrange
        val value = "1"
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Long.ONE, result)
    }

    @Test
    fun `LongTypeConverter should return the expected value for a Char`() {

        // Arrange
        val value = ' '
        val converter = LongTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(32, result)
    }

    @Test
    fun `LongTypeConverter should throw an exception for an unsupported type`() {

        // Arrange
        val value = UUID.randomUUID()
        val converter = LongTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Cannot convert from 'java.util.UUID' to 'long'.", result.message)
    }
}