package org.cozz.validator.core.impl;

import org.cozz.validator.core.ValidatorCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class StringValidators implements ValidatorCollection<String> {

    public static Map<String, Predicate<String>> validations = new HashMap<>();

    static {
        validations.put(StringValidations.LENGTH.getName(), param -> param != null && param.length() == 15);
        validations.put(StringValidations.MIN_LENGTH.getName(), param -> param != null && param.length() > 5);
        validations.put(StringValidations.MAX_LENGTH.getName(), param -> param != null && param.length() < 25);
    }

    @Override
    public String getName() {
        return "STRING";
    }

    @Override
    public Map<String, Predicate<String>> getValidators() {
        return validations;
    }

    enum StringValidations {
        LENGTH("length"),
        MIN_LENGTH("minLength"),
        MAX_LENGTH("maxLength");

        private String name;

        StringValidations(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
