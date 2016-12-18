package org.cozz.validator.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ReflectionUtils {

    public static Object getFieldValue(Field field, Object instance) {
        if (field == null || instance == null)
            throw new IllegalArgumentException("Cannot get field value if field or object is null");
        else {
            field.setAccessible(true);
            try {
                return field.get(instance);
            } catch (IllegalAccessException e) {
                return null;
            }
        }
    }

    public static Set<Field> getObjectFields(Object object) {
        if (object == null) throw new IllegalArgumentException("Cannot check fields on null object");
        else {
            Class clazz = object.getClass();
            return new HashSet<>(Arrays.asList(clazz.getDeclaredFields()));
        }
    }
}
