package io.onixlabs.kotlin.core

/**
 * Gets an empty string.
 */
val String.Companion.EMPTY: String get() = ""

/**
 * Wraps the current string inside the specified start and end strings,
 * or returns an empty string if the current string is null or empty.
 *
 * @param start The start string to prepend to the current string.
 * @param end The end string to append to the current string.
 * @return Returns the current string wrapped inside the specified start and end strings.
 */
fun String?.wrap(start: String, end: String) = if (isNullOrEmpty()) String.EMPTY else "$start$this$end"

/**
 * Formats a string as UPPER_SNAKE_CASE.
 */
fun String.toUpperSnakeCase(): String = buildString {
    val stringThis = this@toUpperSnakeCase
    stringThis.forEachIndexed { index, char ->
        if (index > 0
            && index + 1 < stringThis.length
            && !stringThis[index + 1].isUpperCase()
            && char.isUpperCase()
        ) append("_")
        append(char.toUpperCase())
    }
}

/**
 * Formats a string as lower_snake_case.
 */
fun String.toLowerSnakeCase(): String = buildString {
    val stringThis = this@toLowerSnakeCase
    stringThis.forEachIndexed { index, char ->
        if (index > 0
            && index + 1 < stringThis.length
            && !stringThis[index + 1].isUpperCase()
            && char.isUpperCase()
        ) append("_")
        append(char.toLowerCase())
    }
}

/**
 * Formats a string as UPPER-KEBAB-CASE.
 */
fun String.toUpperKebabCase(): String = buildString {
    val stringThis = this@toUpperKebabCase
    stringThis.forEachIndexed { index, char ->
        if (index > 0
            && index + 1 < stringThis.length
            && !stringThis[index + 1].isUpperCase()
            && char.isUpperCase()
        ) append("-")
        append(char.toUpperCase())
    }
}

/**
 * Formats a string as lower-kebab-case.
 */
fun String.toLowerKebabCase(): String = buildString {
    val stringThis = this@toLowerKebabCase
    stringThis.forEachIndexed { index, char ->
        if (index > 0
            && index + 1 < stringThis.length
            && !stringThis[index + 1].isUpperCase()
            && char.isUpperCase()
        ) append("-")
        append(char.toLowerCase())
    }
}