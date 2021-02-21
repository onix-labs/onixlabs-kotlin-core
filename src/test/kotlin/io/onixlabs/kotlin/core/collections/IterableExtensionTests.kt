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

package io.onixlabs.kotlin.core.collections

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IterableExtensionTests {

    @Test
    fun `Iterable_orderedContentEquals should return true for iterables that contain the same ordered values`() {

        // Arrange
        val a = listOf(123, "Hello, world.", 123.456, true)
        val b = listOf(123, "Hello, world.", 123.456, true)

        // Act
        val result = a.orderedContentEquals(b)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Iterable_orderedContentEquals should return false for iterables that contain different values`() {

        // Arrange
        val a = listOf(123, "Hello, world.", 123.456, true)
        val b = listOf(321, "Hello, earth.", 654.321, false)

        // Act
        val result = a.orderedContentEquals(b)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `Iterable_orderedContentEquals should return false for iterables that contain values in a different order`() {

        // Arrange
        val a = listOf(true, 123.456, "Hello, world.", 123)
        val b = listOf(123, "Hello, world.", 123.456, true)

        // Act
        val result = a.orderedContentEquals(b)

        // Assert
        assertFalse(result)
    }

    @Test
    fun `Iterable_unorderedContentEquals should return true for iterables that contain the same ordered values`() {

        // Arrange
        val a = listOf(123, "Hello, world.", 123.456, true)
        val b = listOf(123, "Hello, world.", 123.456, true)

        // Act
        val result = a.unorderedContentEquals(b)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Iterable_unorderedContentEquals should return true for iterables that contain values in a different order`() {

        // Arrange
        val a = listOf(true, 123.456, "Hello, world.", 123)
        val b = listOf(123, "Hello, world.", 123.456, true)

        // Act
        val result = a.unorderedContentEquals(b)

        // Assert
        assertTrue(result)
    }

    @Test
    fun `Iterable_unorderedContentEquals should return false for iterables that contain different values`() {

        // Arrange
        val a = listOf(123, "Hello, world.", 123.456, true)
        val b = listOf(321, "Hello, earth.", 654.321, false)

        // Act
        val result = a.unorderedContentEquals(b)

        // Assert
        assertFalse(result)
    }
}
