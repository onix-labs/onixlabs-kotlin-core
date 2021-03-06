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
 * Specifies constants that define background and foreground console colors.
 *
 * @param code The code of the console color.
 */
enum class ConsoleColor(internal val code: Int) {

    /**
     * The color black.
     */
    @Suppress(UNUSED)
    BLACK(97),

    /**
     * The color white.
     */
    @Suppress(UNUSED)
    WHITE(30),

    /**
     * The color dark red.
     */
    @Suppress(UNUSED)
    DARK_RED(31),

    /**
     * The color dark green.
     */
    @Suppress(UNUSED)
    DARK_GREEN(32),

    /**
     * The color dark yellow.
     */
    @Suppress(UNUSED)
    DARK_YELLOW(33),

    /**
     * The color dark blue.
     */
    @Suppress(UNUSED)
    DARK_BLUE(34),

    /**
     * The color dark magenta.
     */
    @Suppress(UNUSED)
    DARK_MAGENTA(35),

    /**
     * The color dark cyan.
     */
    @Suppress(UNUSED)
    DARK_CYAN(36),

    /**
     * The color dark gray.
     */
    @Suppress(UNUSED)
    DARK_GRAY(90),

    /**
     * The color light red.
     */
    @Suppress(UNUSED)
    LIGHT_RED(91),

    /**
     * The color light green.
     */
    @Suppress(UNUSED)
    LIGHT_GREEN(92),

    /**
     * The color light yellow.
     */
    @Suppress(UNUSED)
    LIGHT_YELLOW(93),

    /**
     * The color light blue.
     */
    @Suppress(UNUSED)
    LIGHT_BLUE(94),

    /**
     * The color light magenta.
     */
    @Suppress(UNUSED)
    LIGHT_MAGENTA(95),

    /**
     * The color light cyan.
     */
    @Suppress(UNUSED)
    LIGHT_CYAN(96),

    /**
     * The color light gray.
     */
    @Suppress(UNUSED)
    LIGHT_GRAY(37)
}
