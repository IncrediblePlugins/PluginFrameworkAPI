package com.github.angeschossen.pluginframework.api.economy;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Abstraction layer over an economy plugin (e.g. Vault).
 * Implementations bridge the framework's economy calls to the underlying provider.
 */
public interface EconomyIntegration {

    /**
     * Creates a bank account with the given ID, owned by the specified player.
     *
     * @param id            unique bank identifier
     * @param offlinePlayer the owner of the bank account
     * @return {@code true} if the bank was created successfully
     */
    boolean bankCreate(@NotNull String id, @NotNull OfflinePlayer offlinePlayer);

    /**
     * Deposits an amount into the bank account with the given ID.
     *
     * @param id the bank identifier
     * @param d  the amount to deposit
     * @return {@code true} if the deposit was successful
     */
    boolean bankDeposit(@NotNull String id, double d);

    /**
     * Gets the balance of a player by UUID.
     *
     * @param uuid the player's UUID
     * @return the player's current balance
     */
    double getBalance(@NotNull UUID uuid);

    /**
     * Gets the balance of an offline player.
     *
     * @param op the offline player
     * @return the player's current balance
     */
    double getBalance(@NotNull OfflinePlayer op);

    /**
     * Gets the identifier of the server's shared bank account.
     *
     * @return the server bank ID
     */
    @NotNull
    String getServerBankId();

    /**
     * Gives currency to a player identified by UUID.
     *
     * @param playerUUID the recipient's UUID
     * @param value      the amount to give
     * @return {@code true} if the transaction was successful
     */
    boolean give(@NotNull UUID playerUUID, double value);

    /**
     * Gives currency to an offline player.
     *
     * @param op    the recipient
     * @param value the amount to give
     * @return {@code true} if the transaction was successful
     */
    boolean give(@NotNull OfflinePlayer op, double value);

    /**
     * Checks whether a player identified by UUID has at least the given amount.
     *
     * @param playerUUID the player's UUID
     * @param value      the amount to check
     * @return {@code true} if the player has sufficient funds
     */
    boolean has(@NotNull UUID playerUUID, double value);

    /**
     * Checks whether an offline player has at least the given amount.
     *
     * @param op    the offline player
     * @param value the amount to check
     * @return {@code true} if the player has sufficient funds
     */
    boolean has(@NotNull OfflinePlayer op, double value);

    /**
     * Gets the display name of this economy integration.
     *
     * @return the integration name
     */
    @NotNull String getName();

    /**
     * Transfers currency from one player to another.
     *
     * @param from  the player sending currency
     * @param value the amount to transfer
     * @param to    the player receiving currency
     * @return {@code true} if the transfer was successful
     */
    boolean pay(@NotNull OfflinePlayer from, double value, @NotNull OfflinePlayer to);

    /**
     * Takes currency from a player identified by UUID.
     *
     * @param playerUUID the player's UUID
     * @param value      the amount to take
     * @return {@code true} if the transaction was successful
     */
    boolean take(@NotNull UUID playerUUID, double value);

    /**
     * Takes currency from an offline player.
     *
     * @param op    the offline player
     * @param value the amount to take
     * @return {@code true} if the transaction was successful
     */
    boolean take(@NotNull OfflinePlayer op, double value);

    /**
     * Gets the plugin that provides this economy integration.
     *
     * @return the backing plugin
     */
    @NotNull Plugin getPlugin();
}
