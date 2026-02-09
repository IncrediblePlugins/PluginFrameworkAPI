package com.github.angeschossen.pluginframework.api.player;

import com.github.angeschossen.pluginframework.api.limit.holder.LimitHolder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerData extends PlayerDataBase, LimitHolder {
    @NotNull CommandSender getCommandSender();

    Player getPlayer();
}
