package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when an operation is attempted without the required access rights or permissions.
 */
public class NoAccessException extends RuntimeException {

    public NoAccessException(String errorMessage) {
        super(errorMessage);
    }
}
