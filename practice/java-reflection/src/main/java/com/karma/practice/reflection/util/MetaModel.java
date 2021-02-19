package com.karma.practice.reflection.util;

import com.karma.practice.reflection.annotations.Column;
import com.karma.practice.reflection.annotations.PrimaryKey;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public String buildInsertRequest() {
        //insert into Person(id, name ,age) value(?,?,?);
        String columnElement = buildColumnName();
        String questionElement = buildQuestionElement();
        return "insert into "+ this.clss.getSimpleName() + " ( "
                + columnElement +" ) " +"values"+ " ( "
                + questionElement + ")";
    }

    public String buildSelectRequest() {
        //Select id, name ,age from Person where id = ?
        String columnElement = buildColumnName();
        return "Select " + columnElement + " from " +
                this.clss.getSimpleName() +" where "+ getPrimaryKey().getName() + " = ?";
    }

    private String buildQuestionElement() {
        int numberOfColumns = getColumns().size() + 1;
        String questionElement = IntStream.range(0, numberOfColumns).
                mapToObj(index -> "?")
                .collect(Collectors.joining(", "));
        return questionElement;
    }

    private String buildColumnName() {
        String primaryKeyColumnName = getPrimaryKey().getName();
        List<String> columnNames = getColumns()
                .stream()
                .map(ColumnField::getName)
                .collect(Collectors.toList());
        columnNames.add(0,primaryKeyColumnName);
        String columnElement = String.join(",",columnNames);
        return columnElement;
    }


}
