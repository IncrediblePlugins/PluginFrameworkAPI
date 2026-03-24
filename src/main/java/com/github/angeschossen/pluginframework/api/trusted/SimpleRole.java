package com.github.angeschossen.pluginframework.api.trusted;

import com.github.angeschossen.pluginframework.api.flags.roles.ActionFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.ManagementFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.RoleFlag;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Predefined roles used by the trust system of a {@link RoleHolder}.
 * Roles are ordered by priority: {@link #OWNER} has the highest priority and
 * {@link #VISITOR} the lowest. A player with a lower-priority role cannot
 * assign roles equal to or higher than their own.
 * <p>
 * Each role carries a set of allowed {@link ActionFlag}s and {@link ManagementFlag}s
 * that can be configured at runtime via {@link #allow(ActionFlag)} and {@link #allow(ManagementFlag)}.
 */
public enum SimpleRole {

    /** The owner of the protection; has all permissions and cannot be untrused. */
    OWNER(0, 100),
    /** An administrator; has elevated permissions but can be managed by the owner. */
    ADMIN(1, 99),
    /** A regular member with basic access rights. */
    MEMBER(2, 98),
    /** An untrusted visitor with no special access rights. */
    VISITOR(3, 0);

    private static final Map<Integer, SimpleRole> map = new HashMap<>();

    static {
        for (SimpleRole r : values()) {
            map.put(r.id, r);
        }
    }

    private final int id, priority;
    private Set<ManagementFlag> managementFlags = new HashSet<>();
    private Set<ActionFlag> actionFlags = new HashSet<>();
    private String name;
    private String name_plain;

    SimpleRole(int id, int priority) {
        this.id = id;
        this.priority = priority;
        this.name = toString();
        this.name_plain = name;
    }

    /**
     * Looks up a role by its internal numeric ID, defaulting to {@link #MEMBER} for unknown IDs.
     *
     * @param id the role ID
     * @return the matching role, or {@link #MEMBER} if no match is found
     */
    public static SimpleRole getById(int id) {
        return map.getOrDefault(id, MEMBER);
    }

    /**
     * Grants this role permission to perform the specified management flag action.
     *
     * @param flag the management flag to allow
     * @return this role (for chaining)
     */
    public SimpleRole allow(ManagementFlag flag) {
        managementFlags.add(flag);
        return this;
    }

    /**
     * Grants this role permission to perform the specified action flag action.
     *
     * @param flag the action flag to allow
     * @return this role (for chaining)
     */
    public SimpleRole allow(ActionFlag flag) {
        actionFlags.add(flag);
        return this;
    }

    /**
     * Checks whether a player with this role can perform the specified management operation.
     * Returns {@code true} if the role has the flag or the player holds the bypass permission.
     *
     * @param player         the player to check
     * @param managementFlag the management flag to check
     * @return {@code true} if the action is permitted
     */
    public boolean canManagement(Player player, ManagementFlag managementFlag) {
        return hasManagement(managementFlag) || player.hasPermission(managementFlag.getBypassPermission());
    }

    /**
     * Checks whether a player with this role can perform the specified action.
     * Returns {@code true} if the role has the flag or the player holds the bypass permission.
     *
     * @param player     the player to check
     * @param actionFlag the action flag to check
     * @return {@code true} if the action is permitted
     */
    public boolean canRoleSetting(Player player, ActionFlag actionFlag) {
        return hasRoleSetting(actionFlag) || player.hasPermission(actionFlag.getBypassPermission());
    }

    /**
     * Gets the next lower role in the hierarchy (one step demotion).
     *
     * @return the demoted role, or {@code null} if this is {@link #VISITOR} (cannot be demoted further)
     */
    public SimpleRole getDemote() {
        SimpleRole role = getById(getId() + 1);
        return role != VISITOR ? role : null;
    }

    /**
     * Gets the internal numeric ID of this role.
     *
     * @return the role ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the (possibly color-formatted) display name of this role.
     *
     * @return the role name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a custom display name for this role. Spaces are stripped and the plain name is updated.
     *
     * @param name the new display name (may include color codes)
     */
    public void setName(String name) {
        name = name.replace(" ", "");

        this.name = name;
        this.name_plain = ChatColor.stripColor(name);
    }

    /**
     * Gets the role name with all color codes stripped.
     *
     * @return the plain role name
     */
    public String getNamePlain() {
        return name_plain;
    }

    /**
     * Gets the priority of this role. Higher values indicate more authority.
     * {@link #OWNER} has priority 100; {@link #VISITOR} has priority 0.
     *
     * @return the role priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the next higher role in the hierarchy (one step promotion).
     *
     * @return the promoted role, or {@code null} if this is {@link #OWNER} (cannot be promoted further)
     */
    public SimpleRole getPromote() {
        SimpleRole role = getById(getId() - 1);
        return role != OWNER ? role : null;
    }

    /**
     * Checks whether this role has been granted the specified management flag.
     *
     * @param managementFlag the flag to check
     * @return {@code true} if the flag is allowed for this role
     */
    public boolean hasManagement(ManagementFlag managementFlag) {
        return managementFlags.contains(managementFlag);
    }

    /**
     * Checks whether this role has been granted the specified action flag.
     *
     * @param actionFlag the flag to check
     * @return {@code true} if the flag is allowed for this role
     */
    public boolean hasRoleSetting(ActionFlag actionFlag) {
        return actionFlags.contains(actionFlag);
    }

    /**
     * Replaces the entire set of management flags for this role.
     *
     * @param managementSettings the new set of management flags
     */
    public void setManagementSettings(Set<? extends RoleFlag> managementSettings) {
        this.managementFlags = (Set<ManagementFlag>) managementSettings;
    }

    /**
     * Replaces the entire set of action flags for this role.
     *
     * @param roleSettings the new set of action flags
     */
    public void setRoleSettings(Set<? extends RoleFlag> roleSettings) {
        this.actionFlags = (Set<ActionFlag>) roleSettings;
    }
}
