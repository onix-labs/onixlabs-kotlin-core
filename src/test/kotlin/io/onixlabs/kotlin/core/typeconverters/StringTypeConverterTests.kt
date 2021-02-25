package io.onixlabs.kotlin.core.typeconverters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringTypeConverterTests {

    @Test
    fun `StringTypeConverter should return the expected value for a Boolean value true`() {

        // Arrange
        val value = true
        val converter = StringTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals("True", result)
    }

    @Test
    fun `StringTypeConverter should return the expected value for a Boolean value false`() {

        // Arrange
        val value = false
        val converter = StringTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals("False", result)
    }

    @Test
    fun `StringTypeConverter should return the string representation of all types other than Boolean`() {

        // Arrange
        val value = 123456
        val converter = StringTypeConverter()

        // Act
        val result = converter.convert(value)

        // Assert
        assertEquals("123456", result)
    }
}
