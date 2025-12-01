package com.github.angeschossen.pluginframework.api.scheduling;

import com.github.angeschossen.pluginframework.api.scheduling.task.EntityTaskResult;
import com.github.angeschossen.pluginframework.api.scheduling.task.FutureTask;
import com.github.angeschossen.pluginframework.api.scheduling.task.Task;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public interface Scheduler {

    @NotNull Task runTaskAsynchronously(@NotNull Runnable runnable,@NotNull String name);

    @NotNull Task runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay, @NotNull TimeUnit timeUnit,@NotNull String name);

    @NotNull Task runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long interval, @NotNull TimeUnit timeUnit,@NotNull String name);

    @NotNull Task runTask(@NotNull Runnable runnable,@NotNull String name);

    @NotNull Task runTaskLater(@NotNull Runnable runnable,long delay, @NotNull TimeUnit timeUnit,@NotNull String name);

    @NotNull Task runTaskTimer(@NotNull Runnable runnable,long delay, long interval, @NotNull TimeUnit timeUnit,@NotNull String name);

    @NotNull CompletableFuture<Void> runTaskAtLocation(@NotNull Location location, @NotNull Runnable runnable,@NotNull String name);

    @NotNull FutureTask<Void> runTaskAtLocationLater(@NotNull Location location, @NotNull Runnable runnable, long delay, @NotNull TimeUnit unit,@NotNull String name);

    @NotNull Task runTaskTimerAtLocation(@NotNull Location location, @NotNull Runnable runnable, long delay, long period, @NotNull TimeUnit unit,@NotNull String name);

    @NotNull CompletableFuture<@NotNull EntityTaskResult> runTaskAtEntity(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired,@NotNull String name);

    @NotNull Task runTaskAtEntityLater(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired, long delay, @NotNull TimeUnit unit,@NotNull String name);

    @NotNull Task runTaskTimerAtEntity(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired, long delay, long period, @NotNull TimeUnit unit,@NotNull String name);
}
