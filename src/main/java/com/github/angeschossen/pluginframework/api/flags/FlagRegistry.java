package com.github.angeschossen.pluginframework.api.flags;

import com.github.angeschossen.pluginframework.api.flags.roles.ActionFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.ManagementFlag;
import com.github.angeschossen.pluginframework.api.flags.roles.RoleFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface FlagRegistry<A extends ActionFlag, B extends ManagementFlag> {

    @NotNull Collection<A> getActionFlags();

    @NotNull Collection<B> getManagementFlags();

    @Nullable RoleFlag getFlagByName(@NotNull String name);

    @NotNull
    <T extends RoleFlag> T registerFlag(@NotNull T flag) throws IllegalArgumentException;
}
