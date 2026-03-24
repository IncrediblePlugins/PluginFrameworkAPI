package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to assign a name that is already in use by another entity.
 */
public class NameAlreadyTakenException extends RuntimeException {

    /**
     * Creates a new exception with the given detail message.
     *
     * @param errorMessage the detail message
     */
    public NameAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
