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

/**
 * Abstraction over the server's task scheduler, providing thread-aware scheduling
 * compatible with both Folia (region-threaded) and standard Bukkit/Paper servers.
 * <p>
 * All {@code name} parameters are used for debugging and profiling purposes only.
 */
public interface Scheduler {

    /**
     * Schedules a task to run asynchronously as soon as possible.
     *
     * @param runnable the task to run
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskAsynchronously(@NotNull Runnable runnable, @NotNull String name);

    /**
     * Schedules a task to run asynchronously after a delay.
     *
     * @param runnable the task to run
     * @param delay    the delay before execution
     * @param timeUnit the unit for {@code delay}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskLaterAsynchronously(@NotNull Runnable runnable, long delay, @NotNull TimeUnit timeUnit, @NotNull String name);

    /**
     * Schedules a repeating task to run asynchronously.
     *
     * @param runnable the task to run
     * @param delay    the initial delay before the first execution
     * @param interval the interval between subsequent executions
     * @param timeUnit the unit for {@code delay} and {@code interval}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskTimerAsynchronously(@NotNull Runnable runnable, long delay, long interval, @NotNull TimeUnit timeUnit, @NotNull String name);

    /**
     * Schedules a task to run on the main server thread as soon as possible.
     *
     * @param runnable the task to run
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTask(@NotNull Runnable runnable, @NotNull String name);

    /**
     * Schedules a task to run on the main server thread after a delay.
     *
     * @param runnable the task to run
     * @param delay    the delay before execution
     * @param timeUnit the unit for {@code delay}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskLater(@NotNull Runnable runnable, long delay, @NotNull TimeUnit timeUnit, @NotNull String name);

    /**
     * Schedules a repeating task to run on the main server thread.
     *
     * @param runnable the task to run
     * @param delay    the initial delay before the first execution
     * @param interval the interval between subsequent executions
     * @param timeUnit the unit for {@code delay} and {@code interval}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskTimer(@NotNull Runnable runnable, long delay, long interval, @NotNull TimeUnit timeUnit, @NotNull String name);

    /**
     * Runs a task on the thread that owns the region containing the given location (Folia-aware).
     *
     * @param location the location whose owning region should execute the task
     * @param runnable the task to run
     * @param name     a descriptive name for the task
     * @return a future that completes when the task finishes
     */
    @NotNull CompletableFuture<Void> runTaskAtLocation(@NotNull Location location, @NotNull Runnable runnable, @NotNull String name);

    /**
     * Schedules a task to run on the region thread of the given location after a delay.
     *
     * @param location the location whose owning region should execute the task
     * @param runnable the task to run
     * @param delay    the delay before execution
     * @param unit     the unit for {@code delay}
     * @param name     a descriptive name for the task
     * @return a {@link FutureTask} that can be cancelled and whose future completes on execution
     */
    @NotNull FutureTask<Void> runTaskAtLocationLater(@NotNull Location location, @NotNull Runnable runnable, long delay, @NotNull TimeUnit unit, @NotNull String name);

    /**
     * Schedules a repeating task on the region thread of the given location.
     *
     * @param location the location whose owning region should execute the task
     * @param runnable the task to run
     * @param delay    the initial delay before the first execution
     * @param period   the interval between subsequent executions
     * @param unit     the unit for {@code delay} and {@code period}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskTimerAtLocation(@NotNull Location location, @NotNull Runnable runnable, long delay, long period, @NotNull TimeUnit unit, @NotNull String name);

    /**
     * Runs a task on the thread that owns the entity (Folia-aware).
     *
     * @param entity   the entity whose owning thread should execute the task
     * @param runnable the task to run
     * @param retired  called if the entity is removed before the task executes; may be {@code null}
     * @param name     a descriptive name for the task
     * @return a future that resolves to an {@link EntityTaskResult} indicating whether the task ran
     */
    @NotNull CompletableFuture<@NotNull EntityTaskResult> runTaskAtEntity(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired, @NotNull String name);

    /**
     * Schedules a task to run on the entity's owning thread after a delay.
     *
     * @param entity   the entity whose owning thread should execute the task
     * @param runnable the task to run
     * @param retired  called if the entity is removed before the task executes; may be {@code null}
     * @param delay    the delay before execution
     * @param unit     the unit for {@code delay}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskAtEntityLater(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired, long delay, @NotNull TimeUnit unit, @NotNull String name);

    /**
     * Schedules a repeating task on the entity's owning thread.
     *
     * @param entity   the entity whose owning thread should execute the task
     * @param runnable the task to run
     * @param retired  called if the entity is removed before each execution if it has been retired; may be {@code null}
     * @param delay    the initial delay before the first execution
     * @param period   the interval between subsequent executions
     * @param unit     the unit for {@code delay} and {@code period}
     * @param name     a descriptive name for the task
     * @return the created {@link Task}
     */
    @NotNull Task runTaskTimerAtEntity(@NotNull Entity entity, @NotNull Runnable runnable, @Nullable Runnable retired, long delay, long period, @NotNull TimeUnit unit, @NotNull String name);
}
