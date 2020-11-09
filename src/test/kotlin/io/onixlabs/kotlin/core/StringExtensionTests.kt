package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringExtensionTests {

    @Test
    fun `String constant EMPTY should return the correct value`() {
        assertEquals("", String.EMPTY)
    }

    @Test
    fun `String_wrap should wrap a String between the specified start and end values`() {

        // Arrange
        val value = "middle"
        val start = "start-"
        val end = "-end"

        // Act
        val result = value.wrap(start, end)

        // Assert
        assertEquals("start-middle-end", result)
    }

    @Test
    fun `String_toUpperSnakeCase should format a TitleCase string to UPPER_SNAKE_CASE`() {

        // Arrange
        val value = "HelloWorld"

        // Act
        val result = value.toUpperSnakeCase()

        assertEquals("HELLO_WORLD", result)
    }

    @Test
    fun `String_toUpperSnakeCase should format an alternative TitleCase string to UPPER_SNAKE_CASE`() {

        // Arrange
        val value = "XMLReader"

        // Act
        val result = value.toUpperSnakeCase()

        assertEquals("XML_READER", result)
    }

    @Test
    fun `String_toUpperSnakeCase should format a camelCase string to UPPER_SNAKE_CASE`() {

        // Arrange
        val value = "helloWorld"

        // Act
        val result = value.toUpperSnakeCase()

        assertEquals("HELLO_WORLD", result)
    }

    @Test
    fun `String_toLowerSnakeCase should format a TitleCase string to lower_snake_case`() {

        // Arrange
        val value = "HelloWorld"

        // Act
        val result = value.toLowerSnakeCase()

        assertEquals("hello_world", result)
    }

    @Test
    fun `String_toLowerSnakeCase should format an alternative TitleCase string to lower_snake_case`() {

        // Arrange
        val value = "XMLReader"

        // Act
        val result = value.toLowerSnakeCase()

        assertEquals("xml_reader", result)
    }

    @Test
    fun `String_toLowerSnakeCase should format a camelCase string to lower_snake_case`() {

        // Arrange
        val value = "helloWorld"

        // Act
        val result = value.toLowerSnakeCase()

        assertEquals("hello_world", result)
    }

    @Test
    fun `String_toUpperKebabCase should format a TitleCase string to UPPER-KEBAB-CASE`() {

        // Arrange
        val value = "HelloWorld"

        // Act
        val result = value.toUpperKebabCase()

        assertEquals("HELLO-WORLD", result)
    }

    @Test
    fun `String_toUpperKebabCase should format an alternative TitleCase string to UPPER-KEBAB-CASE`() {

        // Arrange
        val value = "XMLReader"

        // Act
        val result = value.toUpperKebabCase()

        assertEquals("XML-READER", result)
    }

    @Test
    fun `String_toUpperKebabCase should format a camelCase string to UPPER-KEBAB-CASE`() {

        // Arrange
        val value = "helloWorld"

        // Act
        val result = value.toUpperKebabCase()

        assertEquals("HELLO-WORLD", result)
    }

    @Test
    fun `String_toLowerKebabCase should format a TitleCase string to lower-kebab-case`() {

        // Arrange
        val value = "HelloWorld"

        // Act
        val result = value.toLowerKebabCase()

        assertEquals("hello-world", result)
    }

    @Test
    fun `String_toLowerKebabCase should format an alternative TitleCase string to lower-kebab-case`() {

        // Arrange
        val value = "XMLReader"

        // Act
        val result = value.toLowerKebabCase()

        assertEquals("xml-reader", result)
    }

    @Test
    fun `String_toLowerKebabCase should format a camelCase string to lower-kebab-case`() {

        // Arrange
        val value = "helloWorld"

        // Act
        val result = value.toLowerKebabCase()

        assertEquals("hello-world", result)
    }
}