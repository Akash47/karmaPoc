package com.karma.practice.reflection.util;

import com.karma.practice.reflection.annotations.PrimaryKey;

import java.lang.reflect.Field;

public class PrimaryKeyField {

    private Field field;
    private PrimaryKey primaryKey;

    public PrimaryKeyField(Field primaryKeys) {
        this.field = primaryKeys;
        this.primaryKey = field.getAnnotation(PrimaryKey.class);
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public String getName() {
        return this.primaryKey.name();
    }

    public Field getField() {
        return field;
    }

}
