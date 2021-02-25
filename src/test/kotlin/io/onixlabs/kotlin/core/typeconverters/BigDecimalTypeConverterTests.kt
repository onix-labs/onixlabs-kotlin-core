package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.ONE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

class BigDecimalTypeConverterTests {

    @Test
    fun `BigDecimalTypeConverter should return ONE when Boolean is true`() {

        // Arrange
        val value = true
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return ZERO when Boolean is false`() {

        // Arrange
        val value = false
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ZERO, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a Byte`() {

        // Arrange
        val value = Byte.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a Short`() {

        // Arrange
        val value = Short.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for an Int`() {

        // Arrange
        val value = Int.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a Long`() {

        // Arrange
        val value = Long.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a BigInteger`() {

        // Arrange
        val value = BigInteger.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a Double`() {

        // Arrange
        val value = Double.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(Double.ONE.toBigDecimal(), result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a BigDecimal`() {

        // Arrange
        val value = BigDecimal.ONE
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(BigDecimal.ONE, result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a String`() {

        // Arrange
        val value = "123.456"
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals((123.456).toBigDecimal(), result)
    }

    @Test
    fun `BigDecimalTypeConverter should return the expected value for a Char`() {

        // Arrange
        val value = ' '
        val converter = BigDecimalTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals(32.toBigDecimal(), result)
    }

    @Test
    fun `BigDecimalTypeConverter should throw an exception for an unsupported type`() {

        // Arrange
        val value = UUID.randomUUID()
        val converter = BigDecimalTypeConverter()

        // Act
        val result = assertThrows<IllegalTypeConversionException> {
            converter.convert(value)
        }

        // Assert
        assertEquals(
            "Illegal type conversion. Cannot convert from 'java.util.UUID' to 'java.math.BigDecimal'.",
            result.message
        )
    }
}