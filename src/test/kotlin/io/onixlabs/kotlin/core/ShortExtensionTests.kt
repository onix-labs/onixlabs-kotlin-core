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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.BigInteger

class ShortExtensionTests {

    @Test
    fun `Short constant ZERO should be the correct value`() {
        assertEquals(0.toShort(), Short.ZERO)
    }

    @Test
    fun `Short constant ONE should be the correct value`() {
        assertEquals(1.toShort(), Short.ONE)
    }

    @Test
    fun `Short_toBigInteger should return a BigInteger representation of the specified value`() {

        // Arrange
        val value = 123.toShort()

        // Act
        val result = value.toBigInteger()

        // Assert
        assertEquals(BigInteger.valueOf(123), result)
    }

    @Test
    fun `Short_toBigDecimal should return a BigDecimal representation of the specified value`() {

        // Arrange
        val value = 123.toShort()

        // Act
        val result = value.toBigDecimal()

        // Assert
        assertEquals(BigDecimal.valueOf(123), result)
    }
}
