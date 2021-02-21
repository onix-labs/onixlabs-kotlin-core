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

package io.onixlabs.kotlin.core

/**
 * Specifies whether the console color applies to the background or the foreground.
 */
internal enum class ConsoleColorModifier {

    /**
     * The specified console color applies to the background.
     */
    BACKGROUND,

    /**
     * The specified console color applies to the foreground.
     */
    FOREGROUND;

    /**
     * Gets the color modifier for the specified console color, or an empty string if the console color is null.
     *
     * @param color The console color from which to obtain a modifier.
     * @return Returns the color modifier for the specified console color.
     */
    fun toColor(color: ConsoleColor?): String = if (color == null) String.EMPTY else when (this) {
        FOREGROUND -> "\u001B[${color.code}m"
        BACKGROUND -> "\u001B[${color.code + 10}m"
    }
}
