package org.cozz.validator.core;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Validations.class)
public @interface Validation {

    ValidationStrategy strategy();

    String method();
}
