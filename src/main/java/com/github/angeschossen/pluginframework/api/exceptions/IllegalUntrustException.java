package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when an untrust operation is attempted that is not permitted,
 * for example when trying to untrust a player who is not currently trusted.
 */
public class IllegalUntrustException extends RuntimeException {

    public IllegalUntrustException(String errorMessage) {
        super(errorMessage);
    }
}
