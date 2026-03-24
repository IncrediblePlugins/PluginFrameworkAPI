package com.github.angeschossen.pluginframework.api.trusted.group;

import org.bukkit.inventory.ItemStack;

/**
 * Represents an enum-backed object that can be displayed in a {@link Group} menu.
 * Implementations typically correspond to protection types or categories within a group.
 */
public interface GroupObject {

    /**
     * Gets the display name of this object.
     *
     * @return the object name
     */
    String getName();

    /**
     * Gets the enum constant that uniquely identifies this object.
     *
     * @return the enum key
     */
    Enum<?> getKey();

    /**
     * Gets the icon used to represent this object in inventory menus.
     *
     * @return the icon item stack
     */
    ItemStack getIcon();
}
