package com.github.angeschossen.pluginframework.api.player;

import com.github.angeschossen.pluginframework.api.limits.LimitationHolder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerData extends PlayerDataBase, LimitationHolder {
    @NotNull CommandSender getCommandSender();

    Player getPlayer();
}
