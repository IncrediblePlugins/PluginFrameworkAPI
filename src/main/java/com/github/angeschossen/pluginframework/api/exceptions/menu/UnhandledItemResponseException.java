package com.github.angeschossen.pluginframework.api.exceptions.menu;

/**
 * Thrown when a menu item click produces a response that has no registered handler.
 */
public class UnhandledItemResponseException extends RuntimeException {

    public UnhandledItemResponseException() {
        super("Unhandled item response");
    }
}
