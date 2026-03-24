package com.github.angeschossen.pluginframework.api.limit.holder;

/**
 * Marker interface for entities that can be targeted by a {@link com.github.angeschossen.pluginframework.api.limit.Limit}.
 * Implementing types identify the kinds of objects a limit applies to, allowing
 * {@link com.github.angeschossen.pluginframework.api.limit.Limit#hasTarget(LimitTarget)} to filter limits by category.
 */
public interface LimitTarget {
}
