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

import io.onixlabs.kotlin.core.isInteger
import io.onixlabs.kotlin.core.math.isInteger
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_LOSS_OF_PRECISION
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [BigInteger] type.
 */
class BigIntegerTypeConverter : TypeConverter<BigInteger>() {

    /**
     * Converts the specified value to the [BigInteger] type.
     *
     * @param value The value to convert.
     * @return Returns an [BigInteger] representation of the specified value.
     */
    override fun convert(value: Any): BigInteger = when (value) {
        is Boolean -> if (value) BigInteger.ONE else BigInteger.ZERO
        is Byte -> BigInteger.valueOf(value.toLong())
        is Short -> BigInteger.valueOf(value.toLong())
        is Int -> BigInteger.valueOf(value.toLong())
        is Long -> BigInteger.valueOf(value)
        is BigInteger -> value
        is Float -> value.toBigIntegerChecked()
        is Double -> value.toBigIntegerChecked()
        is BigDecimal -> value.toBigIntegerChecked()
        is String -> value.toBigInteger()
        is Char -> BigInteger.valueOf(value.toLong())
        else -> throw IllegalTypeConversionException(value.javaClass, BigInteger::class.java)
    }

    /**
     * Performs a checked conversion from [Float] to [BigInteger].
     *
     * @return Returns a [BigInteger] representation of the specified [Float].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [BigInteger].
     */
    private fun Float.toBigIntegerChecked(): BigInteger = when {
        isInteger() -> BigInteger.valueOf(toLong())
        else -> throw NUMERIC_LOSS_OF_PRECISION
    }

    /**
     * Performs a checked conversion from [Double] to [BigInteger].
     *
     * @return Returns a [BigInteger] representation of the specified [Double].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [BigInteger].
     */
    private fun Double.toBigIntegerChecked(): BigInteger = when {
        isInteger() -> BigInteger.valueOf(toLong())
        else -> throw NUMERIC_LOSS_OF_PRECISION
    }

    /**
     * Performs a checked conversion from [BigDecimal] to [BigInteger].
     *
     * @return Returns a [BigInteger] representation of the specified [BigDecimal].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [BigInteger].
     */
    private fun BigDecimal.toBigIntegerChecked(): BigInteger = when {
        isInteger() -> toBigInteger()
        else -> throw NUMERIC_LOSS_OF_PRECISION
    }
}
