package com.github.angeschossen.pluginframework.api.exceptions.menu;

/**
 * Thrown when a menu encounters a type it does not know how to handle.
 */
public class UnhandledMenuTypeException extends RuntimeException {

    public UnhandledMenuTypeException() {
        super("Unhandled menu type");
    }
}
