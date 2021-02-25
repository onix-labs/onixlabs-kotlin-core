package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.ONE
import io.onixlabs.kotlin.core.ZERO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

class ByteTypeConverterTests {

    @Test
    fun `ByteTypeConverter should return ONE when Boolean is true`() {

        // Arrange
        val value = true
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should return ZERO when Boolean is false`() {

        // Arrange
        val value = false
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ZERO, result)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Byte`() {

        // Arrange
        val value = Byte.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Short`() {

        // Arrange
        val value = Short.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Short overflows`() {

        // Arrange
        val value = Short.MAX_VALUE
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for an Int`() {

        // Arrange
        val value = Int.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when an Int overflows`() {

        // Arrange
        val value = Int.MAX_VALUE
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Long`() {

        // Arrange
        val value = Long.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Long overflows`() {

        // Arrange
        val value = Long.MAX_VALUE
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a BigInteger`() {

        // Arrange
        val value = BigInteger.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a BigInteger overflows`() {

        // Arrange
        val value = Long.MAX_VALUE.toBigInteger()
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Float`() {

        // Arrange
        val value = Float.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Float overflows`() {

        // Arrange
        val value = Int.MAX_VALUE.toFloat()
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Float loses precision`() {

        // Arrange
        val value = 123.456F
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Double`() {

        // Arrange
        val value = Double.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Double overflows`() {

        // Arrange
        val value = Double.MAX_VALUE
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Double loses precision`() {

        // Arrange
        val value = 123.456
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a BigDecimal`() {

        // Arrange
        val value = BigDecimal.ONE
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a BigDecimal overflows`() {

        // Arrange
        val value = Long.MAX_VALUE.toBigDecimal()
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a BigDecimal loses precision`() {

        // Arrange
        val value = (123.456).toBigDecimal()
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Loss of precision.", result.message)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a String`() {

        // Arrange
        val value = "1"
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Byte.ONE, result)
    }

    @Test
    fun `ByteTypeConverter should return the expected value for a Char`() {

        // Arrange
        val value = ' '
        val converter = ByteTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(32.toByte(), result)
    }

    @Test
    fun `ByteTypeConverter should throw an exception when a Char overflows`() {

        // Arrange
        val value = '\u1255'
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Numeric overflow.", result.message)
    }

    @Test
    fun `ByteTypeConverter should throw an exception for an unsupported type`() {

        // Arrange
        val value = UUID.randomUUID()
        val converter = ByteTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals("Illegal type conversion. Cannot convert from 'java.util.UUID' to 'kotlin.Byte'.", result.message)
    }
}
