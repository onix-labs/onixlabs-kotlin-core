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

package io.onixlabs.kotlin.core.typeconverters

import io.onixlabs.kotlin.core.*
import io.onixlabs.kotlin.core.math.isInteger
import io.onixlabs.kotlin.core.reflection.kotlinClass
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_LOSS_OF_PRECISION
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_OVERFLOW
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [Byte] type.
 */
class ByteTypeConverter : TypeConverter<Byte>() {

    /**
     * Converts the specified value to the [Byte] type.
     *
     * @param value The value to convert.
     * @return Returns a [Byte] representation of the specified value.
     */
    override fun convert(value: Any): Byte = when (value) {
        is Boolean -> if (value) Byte.ONE else Byte.ZERO
        is Byte -> value
        is Short -> value.toByteChecked()
        is Int -> value.toByteChecked()
        is Long -> value.toByteChecked()
        is BigInteger -> value.toByteChecked()
        is Float -> value.toByteChecked()
        is Double -> value.toByteChecked()
        is BigDecimal -> value.toByteChecked()
        is String -> value.toByte()
        is Char -> value.toByteChecked()
        else -> throw IllegalTypeConversionException(value.kotlinClass, Byte::class)
    }

    /**
     * Performs a checked conversion from [Short] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Short].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Short.toByteChecked(): Byte = when (this) {
        in Byte.MIN_VALUE..Byte.MAX_VALUE -> toByte()
        else -> throw  NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Int] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Int].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Int.toByteChecked(): Byte = when (this) {
        in Byte.MIN_VALUE..Byte.MAX_VALUE -> toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Long] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Long].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Long.toByteChecked(): Byte = when (this) {
        in Byte.MIN_VALUE..Byte.MAX_VALUE -> toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigInteger] to [Boolean].
     *
     * @return Returns a [Boolean] representation of the specified [BigInteger].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Boolean].
     */
    private fun BigInteger.toByteChecked(): Byte = when (this) {
        in Byte.MIN_VALUE.toBigInteger()..Byte.MAX_VALUE.toBigInteger() -> toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Float] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Float].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Float.toByteChecked(): Byte = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Byte.MIN_VALUE.toFloat()..Byte.MAX_VALUE.toFloat() -> toInt().toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Double] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Double].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Double.toByteChecked(): Byte = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Byte.MIN_VALUE.toDouble()..Byte.MAX_VALUE.toDouble() -> toInt().toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigDecimal] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [BigDecimal].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun BigDecimal.toByteChecked(): Byte = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Byte.MIN_VALUE.toBigDecimal()..Byte.MAX_VALUE.toBigDecimal() -> toByte()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Char] to [Byte].
     *
     * @return Returns a [Byte] representation of the specified [Char].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Byte].
     */
    private fun Char.toByteChecked(): Byte = when {
        toShort() in Byte.MIN_VALUE..Byte.MAX_VALUE -> toByte()
        else -> throw NUMERIC_OVERFLOW
    }
}
