package com.github.angeschossen.pluginframework.api.trusted;

import com.github.angeschossen.pluginframework.api.player.PlayerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents an entity (e.g. a protection or claim) that has an owner, a set of trusted players,
 * and a role-based permission system.
 */
public interface RoleHolder {

    /**
     * Checks whether players who are members of a WorldGuard (or similar) region that overlaps
     * this holder are automatically granted member-level access.
     *
     * @return {@code true} if region members are allowed
     */
    boolean isAllowRegionMembers();

    /**
     * Sets whether region members should automatically receive member-level access.
     *
     * @param allowRegionMembers {@code true} to allow region members
     */
    void setAllowRegionMembers(boolean allowRegionMembers);

    /**
     * Gets the UUID of the owner of this holder.
     *
     * @return the owner's UUID
     */
    @NotNull UUID getOwner();

    /**
     * Changes the owner of this holder.
     *
     * @param uid the UUID of the new owner
     */
    void setOwner(UUID uid);

    /**
     * Gets the custom name of this holder, if one has been set.
     *
     * @return the custom name, or {@code null} if no name has been set
     */
    @Nullable
    String getName();

    /**
     * Gets a display name for this holder. Falls back to the owner's name if no custom name is set.
     *
     * @return a non-null display name
     */
    @NotNull
    String getDisplayName();

    /**
     * Sets a custom name for this holder. Pass {@code null} to clear the custom name.
     *
     * @param name the new custom name, or {@code null}
     */
    void setName(@Nullable String name);

    /**
     * Gets the name of this holder's owner.
     *
     * @return the owner's name
     */
    @NotNull
    String getOwnerName();

    /**
     * Opens the management menu for this holder for the given player.
     *
     * @param opener the player who will see the menu
     */
    void openMenu(@NotNull PlayerData opener);

    /**
     * Gets the {@link SimpleRole} assigned to the given player for this holder.
     * Returns a default role (e.g. {@link SimpleRole#VISITOR}) if the player has no explicit role.
     *
     * @param uid the player's UUID
     * @return the player's role
     */
    @NotNull SimpleRole getRole(@NotNull UUID uid);

    /**
     * Gets the UUIDs of all players directly trusted on this holder.
     *
     * @return an unmodifiable collection of trusted player UUIDs
     */
    @NotNull Collection<UUID> getTrusted();

    /**
     * Checks whether the given player is directly trusted on this holder.
     *
     * @param uid the player's UUID
     * @return {@code true} if the player is trusted
     */
    boolean isTrusted(@NotNull UUID uid);

    /**
     * Assigns the given role to the specified player.
     *
     * @param uid  the player's UUID
     * @param role the role to assign
     * @throws IllegalArgumentException if the role assignment is not permitted (e.g. priority violation)
     */
    void setRole(@NotNull UUID uid, @NotNull SimpleRole role) throws IllegalArgumentException;

    /**
     * Trusts a player on this holder, granting them the default member role.
     *
     * @param uid the UUID of the player to trust
     * @return {@code true} if the player was newly trusted; {@code false} if already trusted
     */
    boolean trustPlayer(@NotNull UUID uid);

    /**
     * Untrust a player that is trusted directly to this protection.
     *
     * @param playerUUID The player to untrust
     */
    boolean untrustPlayer(@NotNull UUID playerUUID);
}
