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

import io.onixlabs.kotlin.core.ConsoleColorModifier.BACKGROUND
import io.onixlabs.kotlin.core.ConsoleColorModifier.FOREGROUND

/**
 * Prints the result of the function to the standard output stream.
 * This is useful for main functions where the main function should print a value and return.
 *
 * @param function The function which should return the value to print.
 */
@Suppress(UNUSED)
fun print(function: () -> Any?) = print(function())

/**
 * Prints the result of the function and newline to the standard output stream.
 * This is useful for main functions where the main function should print a value and return.
 *
 * @param function The function which should return the value to print.
 */
@Suppress(UNUSED)
fun println(function: () -> Any?) = println(function())

/**
 * Prints the string representation of the specified value to the standard output stream.
 *
 * @param value The value to print.
 * @param foreground The foreground color.
 * @param background The background color.
 */
@Suppress(UNUSED)
fun print(
    value: Any,
    foreground: ConsoleColor? = null,
    background: ConsoleColor? = null
) = kotlin.io.print("${FOREGROUND.toColor(foreground)}${BACKGROUND.toColor(background)}$value\u001B[0m")

/**
 * Prints the string representation of the specified value and newline to the standard output stream.
 *
 * @param value The value to print.
 * @param foreground The foreground color.
 * @param background The background color.
 */
@Suppress(UNUSED)
fun println(
    value: Any,
    foreground: ConsoleColor? = null,
    background: ConsoleColor? = null
) = kotlin.io.println("${FOREGROUND.toColor(foreground)}${BACKGROUND.toColor(background)}$value\u001B[0m")
