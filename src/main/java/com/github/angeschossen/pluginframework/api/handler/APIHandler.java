package com.github.angeschossen.pluginframework.api.handler;

import org.jetbrains.annotations.NotNull;

/**
 * Singleton entry point for the plugin framework API.
 * Initialized once by the framework implementation; plugin code can retrieve
 * shared handlers via {@link #getInstance()}.
 */
public class APIHandler {
    private final String serverName;
    private static APIHandler instance;
    private final MultiPaperHandler multiPaperHandler;
    private final @NotNull LocaleHandler localeHandler;

    /**
     * Initializes the API handler. May only be called once; a second call throws
     * {@link IllegalStateException}.
     *
     * @param serverName        the name of this server (used for multi-server setups)
     * @param multiPaperHandler the MultiPaper handler implementation
     * @param localeHandler     the locale handler implementation
     * @throws IllegalStateException if the handler has already been initialized
     */
    public APIHandler(@NotNull String serverName, @NotNull MultiPaperHandler multiPaperHandler, @NotNull LocaleHandler localeHandler) {
        if (APIHandler.instance != null) {
            throw new IllegalStateException("Already initialized");
        }

        APIHandler.instance = this;
        this.serverName = serverName;
        this.multiPaperHandler = multiPaperHandler;
        this.localeHandler = localeHandler;
    }

    /**
     * Gets the locale handler for resolving player-specific locales.
     *
     * @return the locale handler
     */
    public @NotNull LocaleHandler getLocaleHandler() {
        return localeHandler;
    }

    /**
     * Returns the global {@link APIHandler} instance.
     *
     * @return the singleton instance, or {@code null} if not yet initialized
     */
    public static APIHandler getInstance() {
        return instance;
    }

    /**
     * Gets the MultiPaper handler used for cross-server checks.
     *
     * @return the MultiPaper handler
     */
    @NotNull
    public final MultiPaperHandler getMultiPaperHandler() {
        return multiPaperHandler;
    }

    /**
     * Gets the name of this server as configured in the framework.
     *
     * @return the server name
     */
    public String getServerName() {
        return serverName;
    }
}
