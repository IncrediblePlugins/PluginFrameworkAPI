package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to untrust the owner of a protected entity, which is not allowed.
 */
public class OwnerUntrustException extends RuntimeException {

    /**
     * Creates a new exception with the given detail message.
     *
     * @param errorMessage the detail message
     */
    public OwnerUntrustException(String errorMessage) {
        super(errorMessage);
    }
}
