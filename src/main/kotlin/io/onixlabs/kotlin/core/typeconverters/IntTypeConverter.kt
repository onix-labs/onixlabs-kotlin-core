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

import io.onixlabs.kotlin.core.ONE
import io.onixlabs.kotlin.core.ZERO
import io.onixlabs.kotlin.core.isInteger
import io.onixlabs.kotlin.core.math.isInteger
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_LOSS_OF_PRECISION
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_OVERFLOW
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [Int] type.
 */
class IntTypeConverter : TypeConverter<Int>() {

    /**
     * Converts the specified value to the [Int] type.
     *
     * @param value The value to convert.
     * @return Returns an [Int] representation of the specified value.
     */
    override fun convert(value: Any): Int = when (value) {
        is Boolean -> if (value) Int.ONE else Int.ZERO
        is Byte -> value.toInt()
        is Short -> value.toInt()
        is Int -> value
        is Long -> value.toIntChecked()
        is BigInteger -> value.toIntChecked()
        is Float -> value.toIntChecked()
        is Double -> value.toIntChecked()
        is BigDecimal -> value.toIntChecked()
        is String -> value.toInt()
        is Char -> value.toInt()
        else -> throw IllegalTypeConversionException(value.javaClass, Int::class.java)
    }

    /**
     * Performs a checked conversion from [Long] to [Int].
     *
     * @return Returns an [Int] representation of the specified [Long].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Int].
     */
    private fun Long.toIntChecked(): Int = when (this) {
        in Int.MIN_VALUE..Int.MAX_VALUE -> toInt()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigInteger] to [Int].
     *
     * @return Returns an [Int] representation of the specified [BigInteger].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Int].
     */
    private fun BigInteger.toIntChecked(): Int = when (this) {
        in Int.MIN_VALUE.toBigInteger()..Int.MAX_VALUE.toBigInteger() -> toInt()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Float] to [Int].
     *
     * @return Returns an [Int] representation of the specified [Float].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Int].
     */
    private fun Float.toIntChecked(): Int = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Int.MIN_VALUE.toFloat()..Int.MAX_VALUE.toFloat() -> toInt()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [Double] to [Int].
     *
     * @return Returns an [Int] representation of the specified [Double].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Int].
     */
    private fun Double.toIntChecked(): Int = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Int.MIN_VALUE.toDouble()..Int.MAX_VALUE.toDouble() -> toInt()
        else -> throw NUMERIC_OVERFLOW
    }

    /**
     * Performs a checked conversion from [BigDecimal] to [Int].
     *
     * @return Returns an [Int] representation of the specified [BigDecimal].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Int].
     */
    private fun BigDecimal.toIntChecked(): Int = when {
        !isInteger() -> throw NUMERIC_LOSS_OF_PRECISION
        this in Int.MIN_VALUE.toBigDecimal()..Int.MAX_VALUE.toBigDecimal() -> toInt()
        else -> throw NUMERIC_OVERFLOW
    }
}
