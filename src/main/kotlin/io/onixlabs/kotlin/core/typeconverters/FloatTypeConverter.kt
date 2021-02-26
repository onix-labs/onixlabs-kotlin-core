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

/**
 * Provides a mechanism to safely convert the specified value value to the [Float] type.
 */
class FloatTypeConverter : TypeConverter<Float>() {

    /**
     * Converts an object from the input type to the output type.
     *
     * @param value The value to convert.
     * @return Returns an instance of the output type.
     */
    override fun convert(value: Any): Float = when (value) {
        is Boolean -> if (value) Float.ONE else Float.ZERO
        is Byte -> value.toFloat()
        is Short -> value.toFloat()
        is Int -> value.toFloat()
        is Float -> value
        is String -> value.toFloat()
        is Char -> value.toFloat()
        else -> throw IllegalTypeConversionException(value.kotlinClass, Float::class)
    }
}
