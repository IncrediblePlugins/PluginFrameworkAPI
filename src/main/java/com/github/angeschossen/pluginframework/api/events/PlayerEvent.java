package com.github.angeschossen.pluginframework.api.events;

import java.util.UUID;

/**
 * Marker interface for events that are associated with a specific player.
 */
public interface PlayerEvent {

    /**
     * Gets the UUID of the player associated with this event.
     *
     * @return the player's UUID
     */
    UUID getPlayerUID();
}
