/**
 * Copyright 2020 Matthew Layton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.onixlabs.kotlin.core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class DoubleExtensionTests {

    @Test
    fun `Double constant ZERO should be the correct value`() {
        assertEquals(0.0, Double.ZERO)
    }

    @Test
    fun `Double constant ONE should be the correct value`() {
        assertEquals(1.0, Double.ONE)
    }

    @Test
    fun `Double_isInteger should return true when the value is an integer`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.isInteger()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Double_isInteger should return false when the value is not an integer`() {

        // Arrange
        val value = 123.456

        // Act
        val result = value.isInteger()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `Double_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Double_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.0

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123.0), result)
    }
}
