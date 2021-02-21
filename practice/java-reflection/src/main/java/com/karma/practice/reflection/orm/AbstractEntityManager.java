package com.karma.practice.reflection.orm;

import com.karma.practice.reflection.util.ColumnField;
import com.karma.practice.reflection.util.MetaModel;
import com.karma.practice.reflection.util.PrimaryKeyField;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractEntityManager<T> implements EntityManager<T> {

    private AtomicLong idGenerator = new AtomicLong(0L);

    @Override
    public void persist(T t) throws SQLException, IllegalAccessException {
        MetaModel metaModel = MetaModel.of(t.getClass());
        String sql = metaModel.buildInsertRequest();
        try(PreparedStatement statement = preparedStatement(sql).setParameters(t)) {
            statement.execute();
        }
    }

    @Override
    public T find(Class<T> clss, Object primaryKey) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        MetaModel metaModel = MetaModel.of(clss);
        String sql = metaModel.buildSelectRequest();
        try(PreparedStatement preparedStatement = preparedStatement(sql).addPrimaryKey(primaryKey)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return buildInstanceFrom(clss, resultSet);
        }
    }

    private T buildInstanceFrom(Class<T> clss, ResultSet resultSet) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        MetaModel metaModel = MetaModel.of(clss);
        T t = clss.getConstructor().newInstance();
        PrimaryKeyField primaryKeyField = metaModel.getPrimaryKey();
        Field field = primaryKeyField.getField();
        String primaryFieldName = primaryKeyField.getName();
        Class<?> primaryFieldType = field.getType();
        resultSet.next();
        if (primaryFieldType == long.class) {
            long primaryKey = resultSet.getLong(primaryFieldName);
            field.setAccessible(true);
            field.set(t, primaryKey);
        }
        for (Object value : metaModel.getColumns()) {
            ColumnField columnField = (ColumnField) value;
            Field aField = columnField.getField();
            String columnFieldName = columnField.getName();
            Class<?> columnFieldType = aField.getType();
            aField.setAccessible(true);
            if (columnFieldType == int.class) {
                int columnKey = resultSet.getInt(columnFieldName);
                aField.set(t, columnKey);
            }
            if (columnFieldType == String.class) {
                String columnKey = resultSet.getString(columnFieldName);
                aField.set(t, columnKey);
            }

        }
        return t;
    }

    private PreparedStatementWrapper preparedStatement(String sql) throws SQLException {
        Connection connection = buildConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return new PreparedStatementWrapper(preparedStatement);
    }

    public abstract Connection buildConnection() throws SQLException;

    private class PreparedStatementWrapper {
        private PreparedStatement preparedStatement;

        public PreparedStatementWrapper(PreparedStatement preparedStatement) {
            this.preparedStatement = preparedStatement;
        }

        public PreparedStatement setParameters(T t) throws SQLException, IllegalAccessException {
            MetaModel metaModel = MetaModel.of(t.getClass());
            Class<?> primaryKeyValue = metaModel.getPrimaryKey().getType();
            if (primaryKeyValue == long.class) {
                long id = idGenerator.incrementAndGet();
                this.preparedStatement.setLong(1, id);
                Field field = metaModel.getPrimaryKey().getField();
                field.setAccessible(true);
                field.set(t, id);
            }
            for (int columnIndex = 0; columnIndex < metaModel.getColumns().size(); columnIndex++) {
                ColumnField columnField = (ColumnField) metaModel.getColumns().get(columnIndex);
                Class<?> fieldType = columnField.getType();
                Field field = columnField.getField();
                field.setAccessible(true);
                Object value = field.get(t);
                if (fieldType == int.class) {
                    this.preparedStatement.setInt(columnIndex + 2, (int) value);
                }
                if (fieldType == String.class) {
                    this.preparedStatement.setString(columnIndex + 2, (String) value);
                }
            }
            return this.preparedStatement;
        }

        public PreparedStatement addPrimaryKey(Object primaryKey) throws SQLException {
            if(primaryKey.getClass()==Long.class) {
                this.preparedStatement.setLong(1,(long)primaryKey);
            }
            return this.preparedStatement;
        }
    }
}
