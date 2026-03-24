package com.github.angeschossen.pluginframework.api.utils;

import java.util.Locale;

/**
 * String utility methods used throughout the framework.
 * Static methods provide locale-safe case conversion; instance method handles color code translation.
 */
public interface StringUtils {

    /**
     * Converts a string to uppercase using the English locale to ensure consistent behavior
     * regardless of the JVM's default locale.
     *
     * @param s the string to convert
     * @return the uppercase string
     */
    static String toUpperCase(String s) {
        return s.toUpperCase(Locale.ENGLISH);
    }

    /**
     * Converts a string to lowercase using the English locale to ensure consistent behavior
     * regardless of the JVM's default locale.
     *
     * @param s the string to convert
     * @return the lowercase string
     */
    static String toLowerCase(String s) {
        return s.toLowerCase(Locale.ENGLISH);
    }

    /**
     * Translates color codes (e.g. {@code &a}, {@code §a}) in the given string into Minecraft
     * chat formatting characters.
     *
     * @param s the string containing color codes
     * @return the colorized string
     */
    String colorize(String s);
}
