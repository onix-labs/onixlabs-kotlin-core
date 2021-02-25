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

/**
 * Represents the exception that is thrown when a type converter is unable to convert the specified value.
 *
 * @param message A message detailing the type conversion exception.
 * @param cause An underlying cause of the type conversion exception.
 */
class IllegalTypeConversionException(message: String, cause: Throwable? = null) : Exception(message, cause) {

    internal companion object {

        /**
         * An [IllegalTypeConversionException] that is thrown when a numeric value overflows.
         */
        val NUMERIC_OVERFLOW = IllegalTypeConversionException("Illegal type conversion. Numeric overflow.")

        /**
         * An [IllegalTypeConversionException] that is thrown when a floating point value loses precision.
         */
        val NUMERIC_LOSS_OF_PRECISION = IllegalTypeConversionException("Illegal type conversion. Loss of precision.")
    }

    /**
     * Creates an [IllegalTypeConversionException] from the specified input and output classes.
     * This exception details that the input class cannot be mapped to the output class.
     *
     * @param inputClass The input class.
     * @param outputClass The output class.
     */
    constructor(inputClass: Class<*>, outputClass: Class<*>) : this(
        "Illegal type conversion. Cannot convert from '${inputClass.canonicalName}' to '${outputClass.canonicalName}'."
    )
}
