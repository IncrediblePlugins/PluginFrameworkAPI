package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to untrust a player who is not currently trusted.
 */
public class PlayerUntrustedException extends RuntimeException {

    /**
     * Creates a new exception with the given detail message.
     *
     * @param errorMessage the detail message
     */
    public PlayerUntrustedException(String errorMessage) {
        super(errorMessage);
    }
}
