package io.onixlabs.kotlin.core.time

import java.time.DayOfWeek
import java.time.temporal.TemporalAccessor
import java.util.*

/**
 * Represents an ordinal occurrence of a day in the month.
 *
 * @param occurrence The occurrence of the day in the month.
 * @param dayOfWeek The day of the week.
 */
class DayOfMonth(val occurrence: DayOfMonthOccurrence, val dayOfWeek: DayOfWeek) {

    companion object {

        /**
         * Creates a [DayOfMonth] instance from the specified [TemporalAccessor] instance.
         *
         * @param temporal The [TemporalAccessor] from which to obtain a [DayOfMonth] instance.
         * @return Returns a [DayOfMonth] instance from the specified [TemporalAccessor] instance.
         */
        fun from(temporal: TemporalAccessor): DayOfMonth {
            return DayOfMonth(DayOfMonthOccurrence.from(temporal), DayOfWeek.from(temporal))
        }

        /**
         * Creates a [DayOfMonth] instance for the first occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the first occurrence of the specified day.
         */
        fun first(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.FIRST, dayOfWeek)

        /**
         * Creates a [DayOfMonth] instance for the second occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the second occurrence of the specified day.
         */
        fun second(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.SECOND, dayOfWeek)

        /**
         * Creates a [DayOfMonth] instance for the third occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the third occurrence of the specified day.
         */
        fun third(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.THIRD, dayOfWeek)

        /**
         * Creates a [DayOfMonth] instance for the fourth occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the fourth occurrence of the specified day.
         */
        fun fourth(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.FOURTH, dayOfWeek)

        /**
         * Creates a [DayOfMonth] instance for the fifth occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the fifth occurrence of the specified day.
         */
        fun fifth(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.FIFTH, dayOfWeek)

        /**
         * Creates a [DayOfMonth] instance for the last occurrence of the specified day.
         *
         * @return Returns a [DayOfMonth] instance for the last occurrence of the specified day.
         */
        fun last(dayOfWeek: DayOfWeek): DayOfMonth = DayOfMonth(DayOfMonthOccurrence.LAST, dayOfWeek)
    }

    /**
     * Determines whether the specified object is equal to the current object.
     *
     * @param other The object to compare with the current object.
     * @return Returns true if the specified object is equal to the current object; otherwise, false.
     */
    override fun equals(other: Any?): Boolean {
        return other != null
                && other is DayOfMonth
                && other.occurrence == occurrence
                && other.dayOfWeek == dayOfWeek
    }

    /**
     * Serves as the default hash function.
     *
     * @return Returns a hash code for the current object.
     */
    override fun hashCode(): Int {
        return Objects.hash(occurrence, dayOfWeek)
    }

    /**
     * Returns a string that represents the current object.
     *
     * @return Returns a string that represents the current object.
     */
    override fun toString(): String {
        return "$occurrence $dayOfWeek"
    }
}