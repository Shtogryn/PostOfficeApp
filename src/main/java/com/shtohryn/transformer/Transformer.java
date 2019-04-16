package com.shtohryn.transformer;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Object fromResultSetModel(ResultSet rs) throws SQLException {
        Object model = null;
        try {
            model = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field f : fields) {
                    if (f.isAnnotationPresent(Column.class)) {
                        Column column = (Column) f.getAnnotation(Column.class);
                        String name = column.name();
                        int length = column.length();
                        f.setAccessible(true);
                        Class fType = f.getType();
                        if (fType == String.class) {
                            f.set(model, rs.getString(name));
                        } else if (fType == Integer.class) {
                            f.set(model, rs.getInt(name));
                        } else if (fType == Time.class) {
                            f.set(model, rs.getTime(name));
                        } else if (fType == BigDecimal.class) {
                            f.set(model, rs.getBigDecimal(name));
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return model;
    }
}

