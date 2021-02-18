package com.karma.practice.reflection.util;

import java.lang.reflect.Field;

public class ColumnField {
    private Field field;
    public ColumnField(Field field) {
        this.field = field;
    }

    public String getName() {
       return this.field.getName();
    }

    public Class<?> getType() {
        return this.field.getType();
    }
}
