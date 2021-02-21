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

package io.onixlabs.kotlin.core.math

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BigDecimalExtensionTests {

    @Test
    fun `BigDecimal_isInteger should return true when the value is an integer`() {

        // Arrange
        val value = 123.toBigDecimal()

        // Act
        val result = value.isInteger()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `BigDecimal_isInteger should return false when the value is not an integer`() {

        // Arrange
        val value = (123.456).toBigDecimal()

        // Act
        val result = value.isInteger()

        // Assert
        assertFalse(result)
    }
}
