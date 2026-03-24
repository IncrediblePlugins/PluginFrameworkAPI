package com.github.angeschossen.pluginframework.api.locale;

/**
 * Describes the environment in which a message or notification is delivered.
 */
public enum Environment {
    /** In-game Minecraft chat or UI. */
    MINECRAFT,
    /** Discord integration (e.g. via a bot). */
    DISCORD
}
