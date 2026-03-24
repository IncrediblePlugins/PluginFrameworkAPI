package com.github.angeschossen.pluginframework.api.utils;

import org.bukkit.Bukkit;

import java.util.Objects;

/**
 * Utility methods for common precondition checks used throughout the framework.
 */
public class Checks {

    /**
     * Private constructor — utility class, not instantiable.
     */
    private Checks() {
    }

    /**
     * Ensures the given object is not {@code null}.
     *
     * @param o   the object to check
     * @param key a descriptive name used in the exception message
     * @param <T> the object type
     * @return the object if non-null
     * @throws NullPointerException if {@code o} is {@code null}
     */
    public static <T> T requireNonNull(T o, String key) {
        Objects.requireNonNull(o, key + " can't be null");
        return o;
    }

    /**
     * Asserts that the current thread is the server's primary (main) thread.
     *
     * @throws IllegalStateException if called from an asynchronous thread
     */
    public static void isSync() {
        if (!Bukkit.isPrimaryThread()) {
            throw new IllegalStateException("Must be called sync");
        }
    }
}
