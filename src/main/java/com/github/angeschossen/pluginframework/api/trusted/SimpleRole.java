package com.github.angeschossen.pluginframework.api.trusted;

import com.github.angeschossen.pluginframework.api.flags.roles.ManagementFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.ActionFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.Flag;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum SimpleRole {

    OWNER(0, 100), ADMIN(1, 99), MEMBER(2, 98), VISITOR(3, 0);

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

    public static SimpleRole getById(int id) {
        return map.getOrDefault(id, MEMBER);
    }

    public void allow(ManagementFlag managementFlag) {
        managementFlags.add(managementFlag);
    }

    public void allow(ActionFlag actionFlag) {
        actionFlags.add(actionFlag);
    }

    public boolean canManagement(Player player, ManagementFlag managementFlag) {
        return hasManagement(managementFlag) || player.hasPermission(managementFlag.getBypassPermission());
    }

    public boolean canRoleSetting(Player player, ActionFlag actionFlag) {
        return hasRoleSetting(actionFlag) || player.hasPermission(actionFlag.getBypassPermission());
    }

    public SimpleRole getDemote() {
        SimpleRole role = getById(getId() + 1);
        return role != VISITOR ? role : null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.replace(" ", "");

        this.name = name;
        this.name_plain = ChatColor.stripColor(name);
    }

    public String getNamePlain() {
        return name_plain;
    }

    public int getPriority() {
        return priority;
    }

    public SimpleRole getPromote() {
        SimpleRole role = getById(getId() - 1);
        return role != OWNER ? role : null;
    }

    public boolean hasManagement(ManagementFlag managementFlag) {
        return managementFlags.contains(managementFlag);
    }

    public boolean hasRoleSetting(ActionFlag actionFlag) {
        return actionFlags.contains(actionFlag);
    }

    public void setManagementSettings(Set<? extends Flag> managementSettings) {
        this.managementFlags = (Set<ManagementFlag>) managementSettings;
    }

    public void setRoleSettings(Set<? extends Flag> roleSettings) {
        this.actionFlags = (Set<ActionFlag>) roleSettings;
    }
}
