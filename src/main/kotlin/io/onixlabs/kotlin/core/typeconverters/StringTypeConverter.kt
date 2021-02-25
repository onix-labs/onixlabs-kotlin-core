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
 * Provides a mechanism to safely convert the specified value value to the [String] type.
 */
class StringTypeConverter : TypeConverter<String>() {

    /**
     * Converts the specified value to the [String] type.
     *
     * @param value The value to convert.
     * @return Returns a [String] representation of the specified value.
     */
    override fun convert(value: Any): String = when (value) {
        // TODO : [Kotlin 1.3] Push values to TRUE_STRING and FALSE_STRING in Boolean.Companion
        is Boolean -> if (value) "True" else "False"
        else -> value.toString()
    }
}
