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

import io.onixlabs.kotlin.core.reflection.kotlinClass

/**
 * Provides a mechanism to safely convert the specified value value to the [Boolean] type.
 */
class BooleanTypeConverter : TypeConverter<Boolean>() {

    private companion object {
        const val EX_NUM_TO_BOOL = "Illegal type conversion. Numeric value cannot be converted to Boolean."
        const val EX_STR_TO_BOOL = "Illegal type conversion. String value cannot be converted to Boolean."
        const val EX_CHR_TO_BOOL = "Illegal type conversion. Char value cannot be converted to Boolean."
    }

    /**
     * Converts the specified value to the [Boolean] type.
     *
     * @param value The value to convert.
     * @return Returns a [Boolean] representation of the specified value.
     */
    override fun convert(value: Any): Boolean = when (value) {
        is Boolean -> value
        is Number -> value.toBooleanChecked()
        is String -> value.toBooleanChecked()
        is Char -> value.toBooleanChecked()
        else -> throw IllegalTypeConversionException(value.kotlinClass, Boolean::class)
    }

    /**
     * Performs a checked conversion from [Number] to [Boolean].
     *
     * @return Returns a [Boolean] representation of the specified [Number].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Boolean].
     */
    private fun Number.toBooleanChecked(): Boolean = when (this) {
        1 -> true
        0 -> false
        else -> throw IllegalTypeConversionException(EX_NUM_TO_BOOL)
    }

    /**
     * Performs a checked conversion from [String] to [Boolean].
     *
     * @return Returns a [Boolean] representation of the specified [String].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Boolean].
     */
    private fun String.toBooleanChecked(): Boolean = when (this.toLowerCase()) {
        "true", "yes", "y", "1" -> true
        "false", "no", "n", "0" -> false
        else -> throw IllegalTypeConversionException(EX_STR_TO_BOOL)
    }

    /**
     * Performs a checked conversion from [Char] to [Boolean].
     *
     * @return Returns a [Boolean] representation of the specified [Char].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [Boolean].
     */
    private fun Char.toBooleanChecked(): Boolean = when (this.toLowerCase()) {
        'y', '1' -> true
        'n', '0' -> false
        else -> throw IllegalTypeConversionException(EX_CHR_TO_BOOL)
    }
}
