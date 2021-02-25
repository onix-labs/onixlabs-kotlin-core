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

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Provides a mechanism to safely convert the specified value value to the [BigDecimal] type.
 */
class BigDecimalTypeConverter : TypeConverter<BigDecimal>() {

    /**
     * Converts the specified value to the [BigDecimal] type.
     *
     * @param value The value to convert.
     * @return Returns a [BigDecimal] representation of the specified value.
     */
    override fun convert(value: Any): BigDecimal = when (value) {
        is Boolean -> if (value) BigDecimal.ONE else BigDecimal.ZERO
        is Byte -> BigDecimal.valueOf(value.toLong())
        is Short -> BigDecimal.valueOf(value.toLong())
        is Int -> BigDecimal.valueOf(value.toLong())
        is Long -> BigDecimal.valueOf(value)
        is BigInteger -> BigDecimal(value)
        is Double -> value.toBigDecimal()
        is BigDecimal -> value
        is String -> value.toBigDecimal().stripTrailingZeros()
        is Char -> BigDecimal.valueOf(value.toLong())
        else -> throw IllegalTypeConversionException(value.javaClass, BigDecimal::class.java)
    }
}
