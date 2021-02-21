package com.karma.practice.reflection.util;

import com.karma.practice.reflection.annotations.Column;

import java.lang.reflect.Field;

public class ColumnField {

    private Field field;

    private Column column;

    public ColumnField(Field field) {
        this.field = field;
        this.column = this.field.getAnnotation(Column.class);
    }

    public String getName() {
        return this.column.name();
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public Field getField() {
        return field;
    }

}
