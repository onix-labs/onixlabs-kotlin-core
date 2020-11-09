package io.onixlabs.kotlin.core.time

import java.time.Duration
import java.util.concurrent.TimeUnit

/**
 * Adds days, hours, minutes, seconds, milliseconds and nanoseconds to an existing [Duration].
 *
 * @param days The number of days to add.
 * @param hours The number of hours to add.
 * @param minutes The number of minutes to add.
 * @param seconds The number of seconds to add.
 * @param milliseconds The number of milliseconds to add.
 * @param nanoseconds The number of nanoseconds to add.
 * @return Returns the updated [Duration] as a new instance.
 */
fun Duration.plus(
    days: Long = 0,
    hours: Long = 0,
    minutes: Long = 0,
    seconds: Long = 0,
    milliseconds: Long = 0,
    nanoseconds: Long = 0
): Duration {
    return this
        .plusDays(days)
        .plusHours(hours)
        .plusMinutes(minutes)
        .plusSeconds(seconds)
        .plusMillis(milliseconds)
        .plusNanos(nanoseconds)
}

/**
 * Converts this duration to the total length in seconds.
 *
 * @return Returns the total length of the duration in milliseconds.
 */
fun Duration.toSeconds(): Long {
    return toMillis() / 1000
}

/**
 * Converts this duration to the total length in microseconds.
 *
 * @return Returns the total length of the duration in microseconds.
 */
fun Duration.toMicros(): Long {
    return toMillis() * 1000
}

/**
 * Converts this duration to the total length of the specified time unit.
 *
 * @param unit The time unit to convert this duration to.
 * @return Returns the total length of the duration for the specified time unit.
 */
fun Duration.toLong(unit: TimeUnit): Long {
    return when (unit) {
        TimeUnit.DAYS -> toDays()
        TimeUnit.HOURS -> toHours()
        TimeUnit.MINUTES -> toMinutes()
        TimeUnit.SECONDS -> toSeconds()
        TimeUnit.MILLISECONDS -> toMillis()
        TimeUnit.MICROSECONDS -> toMicros()
        TimeUnit.NANOSECONDS -> toNanos()
    }
}