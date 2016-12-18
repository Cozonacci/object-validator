package org.cozz.validator.core;

import java.util.Map;
import java.util.function.Predicate;

public interface ValidatorCollection<T> {

    String getName();

    Map<String, Predicate<T>> getValidators();

    default ValidationResult validate(String method, T target) {
        Predicate<T> predicate = getValidators().get(method);
        if (predicate == null)
            throw new RuntimeException(
                    String.format("Could not find validation function %s inside %s collection", method, getName()));
        return new ValidationResult() {
            @Override
            public boolean hasPassed() {
                return predicate.test(target);
            }

            @Override
            public String getDetails() {
                return String.format("Applying [%s] predicate from [%s] validator on target: [%s]",
                        method, getName(), target);
            }
        };
    }
}
