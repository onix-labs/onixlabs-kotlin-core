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