package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when attempting to trust a player who is already trusted.
 */
public class PlayerTrustedException extends RuntimeException {

    public PlayerTrustedException(String errorMessage) {
        super(errorMessage);
    }
}
