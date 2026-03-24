package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to untrust a player who is not currently trusted.
 */
public class PlayerUntrustedException extends RuntimeException {

    public PlayerUntrustedException(String errorMessage) {
        super(errorMessage);
    }
}
