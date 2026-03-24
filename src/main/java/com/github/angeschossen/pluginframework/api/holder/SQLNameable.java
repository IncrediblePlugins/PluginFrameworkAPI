package com.github.angeschossen.pluginframework.api.holder;

import org.jetbrains.annotations.NotNull;

/**
 * Implemented by objects that are stored in a SQL table and have a human-readable name.
 */
public interface SQLNameable {

    /**
     * Gets the SQL table name that stores this type of object.
     *
     * @return the table name
     */
    @NotNull
    String getTableName();

    /**
     * Gets the human-readable name of this object.
     *
     * @return the object's name
     */
    @NotNull
    String getName();
}
