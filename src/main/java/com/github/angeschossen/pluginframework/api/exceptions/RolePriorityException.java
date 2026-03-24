package com.github.angeschossen.pluginframework.api.exceptions;

/**
 * Thrown when a role operation violates priority constraints,
 * for example when trying to assign a role equal to or higher than the caller's own role.
 */
public class RolePriorityException extends RuntimeException {

    public RolePriorityException(String errorMessage) {
        super(errorMessage);
    }
}
