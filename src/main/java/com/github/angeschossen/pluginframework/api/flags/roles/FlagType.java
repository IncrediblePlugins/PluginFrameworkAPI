package com.github.angeschossen.pluginframework.api.flags.roles;

/**
 * Categorises a {@link RoleFlag} as either an action flag or a management flag.
 *
 * <ul>
 *   <li>{@link #ACTION} – controls what actions (e.g. breaking blocks, opening containers) a role can perform.</li>
 *   <li>{@link #MANAGEMENT} – controls administrative operations (e.g. adding members, changing settings) a role can perform.</li>
 * </ul>
 */
public enum FlagType {
    /** Controls in-world actions such as block breaking or interacting with containers. */
    ACTION,
    /** Controls administrative operations such as modifying members or protection settings. */
    MANAGEMENT
}
