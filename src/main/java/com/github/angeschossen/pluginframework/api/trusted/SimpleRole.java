package com.github.angeschossen.pluginframework.api.trusted;

import com.github.angeschossen.pluginframework.api.roles.settings.ManagementSetting;
import com.github.angeschossen.pluginframework.api.roles.settings.RoleSetting;
import com.github.angeschossen.pluginframework.api.roles.settings.Setting;
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
    private Set<ManagementSetting> managementSettings = new HashSet<>();
    private Set<RoleSetting> roleSettings = new HashSet<>();
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

    public void allow(ManagementSetting managementSetting) {
        managementSettings.add(managementSetting);
    }

    public void allow(RoleSetting roleSetting) {
        roleSettings.add(roleSetting);
    }

    public boolean canManagement(Player player, ManagementSetting managementSetting) {
        return hasManagement(managementSetting) || player.hasPermission(managementSetting.getBypassPermission());
    }

    public boolean canRoleSetting(Player player, RoleSetting roleSetting) {
        return hasRoleSetting(roleSetting) || player.hasPermission(roleSetting.getBypassPermission());
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

    public boolean hasManagement(ManagementSetting managementSetting) {
        return managementSettings.contains(managementSetting);
    }

    public boolean hasRoleSetting(RoleSetting roleSetting) {
        return roleSettings.contains(roleSetting);
    }

    public void setManagementSettings(Set<? extends Setting> managementSettings) {
        this.managementSettings = (Set<ManagementSetting>) managementSettings;
    }

    public void setRoleSettings(Set<? extends Setting> roleSettings) {
        this.roleSettings = (Set<RoleSetting>) roleSettings;
    }
}
