package org.cozz.validator.core;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static org.cozz.validator.core.ValidationStrategy.getValidatorCollection;
import static org.cozz.validator.utils.ReflectionUtils.getFieldValue;
import static org.cozz.validator.utils.ReflectionUtils.getObjectFields;

public class ValidationSession {

    public Map<String, List<ValidationResult>> validate(Object object) {
        Map<String, List<ValidationResult>> resultMap = new HashMap<>();
        Set<Field> fieldSet = getObjectFields(object);
        fieldSet.forEach(field -> {
            final String fieldName = field.getName();
            final Object fieldValue = getFieldValue(field, object);
            final List<ValidationResult> fieldValidations = runFieldValidations(field, fieldValue);
            resultMap.put(fieldName, fieldValidations);
        });
        return resultMap;
    }

    public List<ValidationResult> runFieldValidations(Field field, Object target) {
        Validation[] validations = field.getDeclaredAnnotationsByType(Validation.class);
        return Arrays.stream(validations)
                .map(validation -> runValidation(validation, target))
                .collect(Collectors.toList());
    }

    public ValidationResult runValidation(Validation validation, Object target) {
        return getValidatorCollection(validation.strategy()).validate(validation.method(), target);
    }
}
