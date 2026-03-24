package com.github.angeschossen.pluginframework.api.exceptions.menu;

/**
 * Thrown when a menu item click produces a response that has no registered handler.
 */
public class UnhandledItemResponseException extends RuntimeException {

    /**
     * Creates a new exception with the default message {@code "Unhandled item response"}.
     */
    public UnhandledItemResponseException() {
        super("Unhandled item response");
    }
}
