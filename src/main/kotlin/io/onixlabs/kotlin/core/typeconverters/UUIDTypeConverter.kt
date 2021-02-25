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
import java.util.*

/**
 * Provides a mechanism to safely convert the specified value value to the [UUID] type.
 */
class UUIDTypeConverter : TypeConverter<UUID>() {

    /**
     * Converts the specified value to the [UUID] type.
     *
     * @param value The value to convert.
     * @return Returns a [UUID] representation of the specified value.
     */
    override fun convert(value: Any): UUID = when (value) {
        is String -> value.toUUIDChecked()
        is UUID -> value
        else -> throw IllegalTypeConversionException(value.kotlinClass, UUID::class)
    }

    /**
     * Performs a checked conversion from [String] to [UUID].
     *
     * @return Returns a [UUID] representation of the specified [String].
     * @throws IllegalTypeConversionException if the value cannot be safely converted to [UUID].
     */
    private fun String.toUUIDChecked(): UUID = try {
        UUID.fromString(this)
    } catch (ex: IllegalArgumentException) {
        throw IllegalTypeConversionException("Illegal type conversion. ${ex.message}.")
    }
}
