package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to untrust the owner of a protected entity, which is not allowed.
 */
public class OwnerUntrustException extends RuntimeException {

    public OwnerUntrustException(String errorMessage) {
        super(errorMessage);
    }
}
