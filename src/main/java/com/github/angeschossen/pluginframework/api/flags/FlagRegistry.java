package com.github.angeschossen.pluginframework.api.flags;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface FlagRegistry<A extends ActionFlag, B extends ManagementFlag> {

    @NotNull Collection<A> getActionFlags();

    @NotNull Collection<B> getManagementFlags();

    @Nullable Flag getFlagByName(@NotNull String name);

    @NotNull
    <T extends Flag> T registerFlag(@NotNull T flag) throws IllegalArgumentException;
}
