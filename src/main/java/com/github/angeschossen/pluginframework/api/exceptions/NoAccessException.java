package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when an operation is attempted without the required access rights or permissions.
 */
public class NoAccessException extends RuntimeException {

    /**
     * Creates a new exception with the given detail message.
     *
     * @param errorMessage the detail message
     */
    public NoAccessException(String errorMessage) {
        super(errorMessage);
    }
}
