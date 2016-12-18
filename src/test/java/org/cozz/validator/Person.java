package org.cozz.validator;

import org.cozz.validator.core.Validation;

import static org.cozz.validator.core.ValidationStrategy.INT;
import static org.cozz.validator.core.ValidationStrategy.STRING;

public class Person {

    @Validation(strategy = STRING, method = "maxLength")
    @Validation(strategy = STRING, method = "minLength")
    private String name;

    @Validation(strategy = INT, method = "natural")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
