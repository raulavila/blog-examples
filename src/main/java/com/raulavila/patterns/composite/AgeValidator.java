package com.raulavila.patterns.composite;

import com.google.common.collect.Lists;
import com.raulavila.patterns.composite.model.NewUserInfo;

import java.util.List;

public class AgeValidator implements Validator<NewUserInfo> {
    @Override
    public List<String> validate(NewUserInfo info) {
        List<String> errors = Lists.newArrayList();

        int age = info.getAge();

        if (age < 18) {
            errors.add("Age must be >= 18");
        }
        
        return errors;
    }
}
