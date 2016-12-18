package org.cozz.validator.core;

import java.util.function.Predicate;

public interface ValidationFunction<T> {

    String getName();

    String getDescription();

    Predicate<T> getRule();
}
