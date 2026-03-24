package com.github.angeschossen.pluginframework.api.flags.roles;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import com.github.angeschossen.pluginframework.api.utils.Checks;
import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Base class for all role-based flags. A flag represents a permission that can be toggled
 * per {@link com.github.angeschossen.pluginframework.api.trusted.SimpleRole} on a
 * {@link com.github.angeschossen.pluginframework.api.trusted.RoleHolder}.
 * <p>
 * Concrete subclasses must extend either {@link ActionFlag} or {@link ManagementFlag}.
 */
public abstract class RoleFlag {

    /** The plugin that registered this flag. */
    protected final @NotNull Plugin plugin;
    /** The unique, lowercase name of this flag. */
    protected final @NotNull String name;

    /**
     * Creates a new flag owned by the given plugin.
     *
     * @param plugin the owning plugin
     * @param name   the unique flag name (will be converted to lowercase)
     */
    protected RoleFlag(@NotNull Plugin plugin, @NotNull String name) {
        this.plugin = Checks.requireNonNull(plugin, "plugin");
        this.name = StringUtils.toLowerCase(Checks.requireNonNull(name, "name"));
    }

    /**
     * Sends the "access denied" message for this flag to the given player,
     * optionally appending extra placeholders.
     *
     * @param playerData the player to notify
     * @param strings    additional placeholder keys, or {@code null} for none
     * @param strings1   additional placeholder values parallel to {@code strings}, or {@code null} for none
     */
    public void sendDeniedMessage(@NotNull PlayerData playerData, @Nullable String[] strings, @Nullable String[] strings1) {
        String key = getMessageKey();
        if (key == null) {
            return;
        }

        String[] p, v;
        if (strings != null && strings1 != null) {
            p = ArrayUtils.addAll(getDefaultPlaceholders(), strings);
            v = ArrayUtils.addAll(getDefaultPlaceholderValues(), strings1);
        } else {
            p = null;
            v = null;
        }

        playerData.sendMessage(key, p, v);
    }

    /**
     * Returns the message key used to look up the "access denied" message for this flag.
     * Return {@code null} to suppress the denied message entirely.
     *
     * @return the message key, or {@code null}
     */
    protected @Nullable String getMessageKey() {
        return null;
    }

    /**
     * Gets the plugin that owns this flag.
     *
     * @return the owning plugin
     */
    public final @NotNull Plugin getPlugin() {
        return plugin;
    }

    /**
     * Returns the permission node that allows a player to bypass this flag's restriction.
     *
     * @return the bypass permission node
     */
    @NotNull
    public abstract String getBypassPermission();

    /**
     * Gets the unique name of this flag (always lowercase).
     *
     * @return the flag name
     */
    @NotNull
    public final String getName() {
        return name;
    }

    /**
     * Gets the type of this flag.
     *
     * @return {@link FlagType#ACTION} or {@link FlagType#MANAGEMENT}
     */
    @NotNull
    public abstract FlagType getType();

    /**
     * Returns the permission node that allows a role to toggle this flag.
     *
     * @return the toggle permission node
     */
    @NotNull
    public abstract String getTogglePermission();

    /**
     * Returns the default placeholder keys used in denied messages: {@code {flag}} and {@code {bypass}}.
     *
     * @return array of placeholder keys
     */
    @NotNull
    protected static String[] getDefaultPlaceholders() {
        return new String[]{"{flag}", "{bypass}"};
    }

    /**
     * Returns the values for the default placeholders: the flag name and the bypass permission.
     *
     * @return array of placeholder values
     */
    @NotNull
    protected final String[] getDefaultPlaceholderValues() {
        return new String[]{getName(), getBypassPermission()};
    }
}
