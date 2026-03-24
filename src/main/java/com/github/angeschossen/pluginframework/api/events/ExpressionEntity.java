package com.github.angeschossen.pluginframework.api.events;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Implemented by entities that contribute players and variables to expression evaluation.
 * Used to populate placeholder contexts for conditional expressions (e.g. in automation or event triggers).
 */
public interface ExpressionEntity {

    /**
     * Populates the given builder with the UUIDs of players affected by this entity.
     * Each entry is keyed by a namespaced string derived from the given prefix.
     *
     * @param prefix  a namespace prefix to disambiguate entries from different entities
     * @param builder the map builder to populate
     */
    void setAffectedPlayers(@NotNull String prefix, ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder);

    /**
     * Populates the given builder with expression variables exposed by this entity.
     * Each entry is keyed by a namespaced string derived from the given prefix.
     *
     * @param prefix    a namespace prefix to disambiguate entries from different entities
     * @param builder   the map builder to populate
     * @param playerUID the UUID of the player the expression is evaluated for, or {@code null} if not player-specific
     */
    void setExpressionVariables(@NotNull String prefix, @NotNull ImmutableMap.Builder<String, Object> builder, @Nullable UUID playerUID);
}
