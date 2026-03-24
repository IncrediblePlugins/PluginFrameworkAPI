package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to trust a player who is already trusted.
 */
public class PlayerTrustedException extends RuntimeException {

    /**
     * Creates a new exception with the given detail message.
     *
     * @param errorMessage the detail message
     */
    public PlayerTrustedException(String errorMessage) {
        super(errorMessage);
    }
}
