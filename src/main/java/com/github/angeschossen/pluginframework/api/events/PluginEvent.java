package com.github.angeschossen.pluginframework.api.events;

import com.google.common.collect.ImmutableMap;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Base class for all framework events. Automatically handles async detection so subclasses
 * do not need to pass the {@code isAsync} flag manually.
 * <p>
 * Subclasses must implement {@link #setAffectedPlayers} and {@link #setExpressionVariables}
 * to expose their context to the expression/automation system.
 */
public abstract class PluginEvent extends Event {

    public PluginEvent() {
        super(!Bukkit.isPrimaryThread());
    }

    /**
     * Populates the builder with the UUIDs of players affected by this event.
     *
     * @param builder the map builder to populate
     */
    public abstract void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder);

    /**
     * Populates the builder with expression variables exposed by this event.
     *
     * @param builder the map builder to populate
     */
    public abstract void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder);

    /**
     * Returns a short human-readable string describing this event for logging purposes.
     *
     * @return a log info string, or {@code null} if no logging information is available
     */
    @Nullable
    public String getLogInfo() {
        return null;
    }
}
