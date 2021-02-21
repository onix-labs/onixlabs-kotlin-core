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

package io.onixlabs.kotlin.core.time

import java.time.LocalDate
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalAdjusters

/**
 * Represents the ordinal occurrence of a day in the month.
 */
enum class DayOfMonthOccurrence {

    /**
     * The first occurrence of the specified day in the month.
     */
    FIRST,

    /**
     * The second occurrence of the specified day in the month.
     */
    SECOND,

    /**
     * The third occurrence of the specified day in the month.
     */
    THIRD,

    /**
     * The fourth occurrence of the specified day in the month.
     */
    FOURTH,

    /**
     * The fifth occurrence of the specified day in the month.
     */
    FIFTH,

    /**
     * The last occurrence of the specified day in the month.
     */
    LAST;

    companion object {

        /**
         * Gets the ordinal occurrence of the day in the month for the specified [TemporalAccessor].
         *
         * @param temporal The [TemporalAccessor] from which to obtain the ordinal occurrence of the day in the month.
         * @return Returns the ordinal occurrence of the day in the month for the specified [TemporalAccessor].
         */
        fun from(temporal: TemporalAccessor): DayOfMonthOccurrence {
            return valueOf(getOrdinalPosition(temporal))
        }

        /**
         * Determines whether the specified [TemporalAccessor] is the last occurrence of the day in the month.
         *
         * @param temporal The [TemporalAccessor] from which to obtain the day of the month.
         * @Return Returns true if the day of the month is the last occurrence of that day; otherwise, false.
         */
        fun isLastOccurrence(temporal: TemporalAccessor): Boolean {
            val date = LocalDate.from(temporal)
            return date == date.with(TemporalAdjusters.lastInMonth(date.dayOfWeek))
        }

        /**
         * Gets the [DayOfMonthOccurrence] value for the specified [Int] value.
         *
         * @param value The [DayOfMonthOccurrence] day of month value.
         * @return Returns the ordinal day of month value for the specified day of month value.
         */
        fun valueOf(value: Int): DayOfMonthOccurrence {
            return when (value) {
                1 -> FIRST
                2 -> SECOND
                3 -> THIRD
                4 -> FOURTH
                5 -> FIFTH
                else -> throw IllegalArgumentException("$value is not a valid day position within a month")
            }
        }

        /**
         * Gets the ordinal position of the day in the month for the specified [TemporalAccessor].
         *
         * @param temporal The [TemporalAccessor] from which to obtain the ordinal position.
         * @return Returns the ordinal position of the day in the month for the specified [TemporalAccessor].
         */
        private fun getOrdinalPosition(temporal: TemporalAccessor): Int {
            return ((LocalDate.from(temporal).dayOfMonth - 1) / 7) + 1
        }
    }
}
