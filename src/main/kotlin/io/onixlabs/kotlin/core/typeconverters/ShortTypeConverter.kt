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
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_LOSS_OF_PRECISION
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_OVERFLOW
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [Short] type.
 */
class ShortTypeConverter : TypeConverter<Short>() {

    /**
     * Converts the specified value to the [Short] type.
     *
     * @param value The value to convert.
     * @return Returns a [Short] representation of the specified value.
     */
    override fun convert(value: Any): Short = when (value) {
        is Boolean -> if (value) Short.ONE else Short.ZERO
        is Byte -> value.toShort()
        is Short -> value
        is Int -> value.toShortChecked()
        is Long -> value.toShortChecked()
        is BigInteger -> value.toShortChecked()
        is Float -> value.toShortChecked()
        is Double -> value.toShortChecked()
        is BigDecimal -> value.toShortChecked()
        is String -> value.toShort()
        is Char -> value.toShort()
        else -> throw IllegalTypeConversionException(value.javaClass, Short::class.java)
    }

    /**
     * Performs a checked conversion from [Int] to [Short].
     *
     * @return Returns a [Short] representation of the specified [Int].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun Int.toShortChecked(): Short = when (this) {
        in Short.MIN_VALUE..Short.MAX_VALUE -> toShort()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Long] to [Short].
     *
     * @return Returns a [Short] representation of the specified [Long].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun Long.toShortChecked(): Short = when (this) {
        in Short.MIN_VALUE..Short.MAX_VALUE -> toShort()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigInteger] to [Short].
     *
     * @return Returns a [Short] representation of the specified [BigInteger].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun BigInteger.toShortChecked(): Short = when (this) {
        in Short.MIN_VALUE.toBigInteger()..Short.MAX_VALUE.toBigInteger() -> toShort()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Float] to [Short].
     *
     * @return Returns a [Short] representation of the specified [Float].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun Float.toShortChecked(): Short = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Short.MIN_VALUE.toFloat()..Short.MAX_VALUE.toFloat() -> toInt().toShort()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Double] to [Short].
     *
     * @return Returns a [Short] representation of the specified [Double].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun Double.toShortChecked(): Short = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Short.MIN_VALUE.toDouble()..Short.MAX_VALUE.toDouble() -> toInt().toShort()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigDecimal] to [Short].
     *
     * @return Returns a [Short] representation of the specified [BigDecimal].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Short].
     */
    private fun BigDecimal.toShortChecked(): Short = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Short.MIN_VALUE.toBigDecimal()..Short.MAX_VALUE.toBigDecimal() -> toShort()
        else -> throw NUMERIC_OVERFLOW
    }
}
