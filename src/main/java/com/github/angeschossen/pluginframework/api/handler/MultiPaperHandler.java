package com.github.angeschossen.pluginframework.api.handler;

/**
 * Abstraction over MultiPaper's cross-server routing.
 * Used to determine whether a given server name refers to the current server.
 */
public interface MultiPaperHandler {

    /**
     * Checks whether the given server name matches this server.
     * In a non-MultiPaper setup this always returns {@code true}.
     *
     * @param serverName the server name to test
     * @return {@code true} if the given name refers to this server
     */
    boolean isTargetServer(String serverName);
}
