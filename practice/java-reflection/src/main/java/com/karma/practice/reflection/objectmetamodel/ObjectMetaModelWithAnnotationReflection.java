package com.karma.practice.reflection.objectmetamodel;

import com.karma.practice.reflection.util.ColumnField;
import com.karma.practice.reflection.util.MetaModel;
import com.karma.practice.reflection.model.Person;
import com.karma.practice.reflection.util.PrimaryKeyField;

import java.util.List;

public class ObjectMetaModelWithAnnotationReflection {
    public static void main(String[] args) {
        MetaModel<Person> metaModel = MetaModel.of(Person.class);
        PrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        List<ColumnField> columnFields = metaModel.getColumns();

        System.out.println("Primary key name: " + primaryKeyField.getName() +
                "  type: " + primaryKeyField.getType().getSimpleName()
        );

        for (ColumnField column:columnFields) {
            System.out.println("Primary key name: " + column.getName() +
                    "  type: " + column.getType().getSimpleName()
            );
        }
    }
}
