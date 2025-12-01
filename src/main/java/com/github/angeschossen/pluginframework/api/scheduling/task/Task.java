package com.github.angeschossen.pluginframework.api.scheduling.task;

import org.jetbrains.annotations.NotNull;

public interface Task {

    boolean isCancelled();

    boolean isSync();

    @NotNull
    String getName();

    void cancel();

    boolean isPending();
}
