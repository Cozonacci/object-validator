package org.cozz.validator;

import org.cozz.validator.core.ValidationResult;
import org.cozz.validator.core.ValidationSession;
import org.junit.Test;

import java.util.stream.Collectors;

public class PersonValidationTest {

    @Test
    public void shouldValidatePersonObjectBasedOnContract() {
        Person person = new Person("Andrei", -23);
        new ValidationSession().validate(person).forEach((n, r) ->
                System.out.println(
                        String.format("field: %s -> %s",
                                n, r.stream().map(ValidationResult::getDetails).collect(Collectors.toList())))
        );
    }
}
