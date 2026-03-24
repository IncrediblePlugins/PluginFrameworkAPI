package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to assign a name that is already in use by another entity.
 */
public class NameAlreadyTakenException extends RuntimeException {

    public NameAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
