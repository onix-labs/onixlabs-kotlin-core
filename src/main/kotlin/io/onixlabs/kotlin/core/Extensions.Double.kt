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
 * Gets the constant ZERO of type [Double].
 */
val Double.Companion.ZERO: Double get() = 0.0

/**
 * Gets the constant ONE of type [Double].
 */
val Double.Companion.ONE: Double get() = 1.0

/**
 * Determines whether the specified value represents an integer.
 *
 * @return Returns true if the specified value represents an integer; otherwise, false.
 */
fun Double.isInteger(): Boolean = this % Double.ONE == Double.ZERO

/**
 * Converts a [Double] value to a [BigInteger] value.
 *
 * @return Returns a [BigInteger] representation of this [Double] value.
 */
fun Double.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

/**
 * Converts a [Double] value to a [BigDecimal] value.
 *
 * @return Returns a [BigDecimal] representation of this [Double] value.
 */
fun Double.toBigDecimal(): BigDecimal = BigDecimal.valueOf(this)
