package org.cozz.validator.core;

import org.cozz.validator.core.impl.IntValidators;
import org.cozz.validator.core.impl.StringValidators;

public enum ValidationStrategy {
    STRING,
    INT;

    public static ValidatorCollection getValidatorCollection(final ValidationStrategy validationStrategy) {
        switch (validationStrategy) {
            case INT:
                return new IntValidators();
            case STRING:
                return new StringValidators();
            default:
                throw new IllegalArgumentException("Could not identify validation strategy for " + validationStrategy);
        }
    }
}
