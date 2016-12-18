package org.cozz.validator.core;

public interface ValidationResult {

    boolean hasPassed();

    String getDetails();
}
