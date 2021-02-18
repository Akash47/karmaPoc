package com.karma.practice.reflection.util;

import com.karma.practice.reflection.annotations.Column;
import com.karma.practice.reflection.annotations.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetaModel<T> {
    private Class<T> clss;

    public static <T>MetaModel of(Class<T> clss) {
        return new MetaModel(clss);
    }

    public MetaModel(Class<T> clss) {
        this.clss = clss;
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] fields = this.clss.getDeclaredFields();
        for (Field field : fields) {
            PrimaryKey primaryKeys = field.getAnnotation(PrimaryKey.class);
            if (primaryKeys != null) {
                return new PrimaryKeyField(field);
            }
        }
        return null;
    }

    public List<ColumnField> getColumns() {
        List<ColumnField> aColumnFields = new ArrayList<>();
        Field[] fields = this.clss.getDeclaredFields();
        for (Field field : fields) {
            Column columnKeys = field.getAnnotation(Column.class);
            if (columnKeys != null) {
                aColumnFields.add( new ColumnField(field));
            }
        }
        return aColumnFields;
    }
}
