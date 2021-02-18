package com.karma.practice.reflection.util;

import com.karma.practice.reflection.annotations.PrimaryKey;

import java.lang.reflect.Field;

public class PrimaryKeyField {
    private Field field ;
    public PrimaryKeyField( Field primaryKeys) {
        this.field = primaryKeys;
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public String getName() {
        return this.field.getName();
    }
}
