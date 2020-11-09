package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class IntExtensionTests {

    @Test
    fun `Int constant ZERO should be the correct value`() {
        assertEquals(0, Int.ZERO)
    }

    @Test
    fun `Int constant ONE should be the correct value`() {
        assertEquals(1, Int.ONE)
    }

    @Test
    fun `Int_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Int_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123), result)
    }
}