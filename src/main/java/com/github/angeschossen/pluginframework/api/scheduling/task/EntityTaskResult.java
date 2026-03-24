package com.github.angeschossen.pluginframework.api.scheduling.task;

/**
 * Describes the outcome of a task that was scheduled to run on an entity's owning thread.
 */
public enum EntityTaskResult {
    /** The task ran successfully. */
    SUCCESS,
    /** The task did not run because the entity was removed before execution. */
    ENTITY_RETIRED,
    /** The task did not run because the scheduler was shut down before execution. */
    SCHEDULER_RETIRED
}
