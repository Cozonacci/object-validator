package org.cozz.validator.core.impl;

import org.cozz.validator.core.ValidatorCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class IntValidators implements ValidatorCollection<Integer> {

    public static Map<String, Predicate<Integer>> validations = new HashMap<>();

    static {
        validations.put(IntValidations.NATURAL.getName(), param -> param >= 0);
    }

    @Override
    public String getName() {
        return "INT";
    }

    @Override
    public Map<String, Predicate<Integer>> getValidators() {
        return validations;
    }

    enum IntValidations {
        NATURAL("natural");

        private String name;

        IntValidations(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
