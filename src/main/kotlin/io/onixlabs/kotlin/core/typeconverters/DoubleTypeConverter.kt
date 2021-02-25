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
import io.onixlabs.kotlin.core.reflection.kotlinClass
import io.onixlabs.kotlin.core.toBigInteger
import io.onixlabs.kotlin.core.typeconverters.IllegalTypeConversionException.Companion.NUMERIC_OVERFLOW
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [Double] type.
 */
class DoubleTypeConverter : TypeConverter<Double>() {

    /**
     * Converts the specified value to the [Double] type.
     *
     * @param value The value to convert.
     * @return Returns a [Double] representation of the specified value.
     */
    override fun convert(value: Any): Double = when (value) {
        is Boolean -> if (value) Double.ONE else Double.ZERO
        is Byte -> value.toDouble()
        is Short -> value.toDouble()
        is Int -> value.toDouble()
        is Long -> value.toDouble()
        is BigInteger -> value.toDoubleChecked()
        is Double -> value
        is String -> value.toDouble()
        is Char -> value.toDouble()
        else -> throw IllegalTypeConversionException(value.kotlinClass, Double::class)
    }

    /**
     * Performs a checked conversion from [BigInteger] to [Double].
     *
     * @return Returns a [Double] representation of the specified [BigInteger].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Double].
     */
    private fun BigInteger.toDoubleChecked(): Double = when (this) {
        in Double.MIN_VALUE.toBigInteger()..Double.MAX_VALUE.toBigInteger() -> toDouble()
        else -> throw NUMERIC_OVERFLOW
    }
}
