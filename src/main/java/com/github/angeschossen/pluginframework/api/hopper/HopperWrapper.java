package com.github.angeschossen.pluginframework.api.hopper;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Wraps a hopper (or hopper-like) inventory and provides item insertion functionality.
 */
public interface HopperWrapper {

    /**
     * Attempts to add an item to this hopper's inventory.
     *
     * @param item   the item stack to insert
     * @param delete if {@code true}, the item is consumed even if the inventory is full
     * @return the leftover item stack that could not be inserted, or {@code null} if the item was fully accepted
     */
    @Nullable ItemStack addItem(ItemStack item, boolean delete);

    /**
     * Checks whether this hopper's inventory is full and cannot accept any more items.
     *
     * @return {@code true} if the inventory is full
     */
    boolean isFull();
}
