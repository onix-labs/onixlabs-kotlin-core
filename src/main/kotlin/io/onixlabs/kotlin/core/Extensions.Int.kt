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

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Gets the constant ZERO of type [Int].
 */
val Int.Companion.ZERO: Int get() = 0

/**
 * Gets the constant ONE of type [Int].
 */
val Int.Companion.ONE: Int get() = 1

/**
 * Converts an [Int] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Int] value.
 */
fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts an [Int] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Int] value.
 */
fun Int.toBigDecimal(): BigDecimal = BigDecimal.valueOf(toLong())
