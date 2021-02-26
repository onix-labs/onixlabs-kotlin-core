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

package io.onixlabs.kotlin.core.reflection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KTypeProjection
import kotlin.reflect.full.createType

class KTypeExtensionTests {

    @Test
    fun `KType_name should return the expected name for a non-nullable parameterless type`() {

        // Arrange
        val type = UUID::class.createType(nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("UUID", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable parameterless type`() {

        // Arrange
        val type = UUID::class.createType(nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("UUID?", name)
    }

    @Test
    fun `KType_name should return the expected name for a non-nullable type with a single non-nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = false)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("ArrayList<Int>", name)
    }

    @Test
    fun `KType_name should return the expected name for a non-nullable type with a single nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = true)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("ArrayList<Int?>", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable type with a single non-nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = false)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("ArrayList<Int>?", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable type with a single nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = true)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("ArrayList<Int?>?", name)
    }

    @Test
    fun `KType_name should return the expected name for a non-nullable type with multiple non-nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = false)),
            KTypeProjection.invariant(Double::class.createType(nullable = false))
        )

        val type = Map::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("Map<String, Double>", name)
    }

    @Test
    fun `KType_name should return the expected name for a non-nullable type with multiple nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = true)),
            KTypeProjection.invariant(Double::class.createType(nullable = true))
        )

        val type = Map::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("Map<String?, Double?>", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable type with multiple non-nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = false)),
            KTypeProjection.invariant(Double::class.createType(nullable = false))
        )

        val type = Map::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("Map<String, Double>?", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable type with multiple nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = true)),
            KTypeProjection.invariant(Double::class.createType(nullable = true))
        )

        val type = Map::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        assertEquals("Map<String?, Double?>?", name)
    }

    @Test
    fun `KType_name should return the expected name for a non-nullable type a single star projected type`() {

        // Arrange
        val arguments = listOf(KTypeProjection.STAR)
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedSimpleName

        // Assert
        //fail(type.arguments.joinToString())
        assertEquals("ArrayList<*>", name)
    }

    @Test
    fun `KType_name should return the expected name for a nullable type a single star projected type`() {

        // Arrange
        val arguments = listOf(KTypeProjection.STAR)
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedSimpleName

        // Assert
        //fail(type.arguments.joinToString())
        assertEquals("ArrayList<*>?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable parameterless type`() {

        // Arrange
        val type = UUID::class.createType(nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.UUID", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable parameterless type`() {

        // Arrange
        val type = UUID::class.createType(nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.UUID?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable type with a single non-nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = false)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<kotlin.Int>", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable type with a single nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = true)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<kotlin.Int?>", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable type with a single non-nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = false)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<kotlin.Int>?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable type with a single nullable parameter`() {

        // Arrange
        val arguments = listOf(KTypeProjection.invariant(Int::class.createType(nullable = true)))
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<kotlin.Int?>?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable type with multiple non-nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = false)),
            KTypeProjection.invariant(Double::class.createType(nullable = false))
        )

        val type = Map::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("kotlin.collections.Map<kotlin.String, kotlin.Double>", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable type with multiple nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = true)),
            KTypeProjection.invariant(Double::class.createType(nullable = true))
        )

        val type = Map::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("kotlin.collections.Map<kotlin.String?, kotlin.Double?>", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable type with multiple non-nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = false)),
            KTypeProjection.invariant(Double::class.createType(nullable = false))
        )

        val type = Map::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("kotlin.collections.Map<kotlin.String, kotlin.Double>?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable type with multiple nullable parameters`() {

        // Arrange
        val arguments = listOf(
            KTypeProjection.invariant(String::class.createType(nullable = true)),
            KTypeProjection.invariant(Double::class.createType(nullable = true))
        )

        val type = Map::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("kotlin.collections.Map<kotlin.String?, kotlin.Double?>?", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a non-nullable type a single star projected type`() {

        // Arrange
        val arguments = listOf(KTypeProjection.STAR)
        val type = ArrayList::class.createType(arguments = arguments, nullable = false)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<*>", name)
    }

    @Test
    fun `KType_fullName should return the expected fullName for a nullable type a single star projected type`() {

        // Arrange
        val arguments = listOf(KTypeProjection.STAR)
        val type = ArrayList::class.createType(arguments = arguments, nullable = true)

        // Act
        val name = type.formattedQualifiedName

        // Assert
        assertEquals("java.util.ArrayList<*>?", name)
    }
}
