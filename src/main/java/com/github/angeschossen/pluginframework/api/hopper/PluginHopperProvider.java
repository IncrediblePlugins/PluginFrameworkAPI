package com.github.angeschossen.pluginframework.api.hopper;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link HopperProvider} backed by a Bukkit {@link Plugin}.
 * Use this interface when registering a hopper integration that is tied to a specific plugin.
 */
public interface PluginHopperProvider extends HopperProvider {

    /**
     * Gets the plugin that provides this hopper integration.
     *
     * @return the backing plugin
     */
    @NotNull Plugin getPlugin();
}
