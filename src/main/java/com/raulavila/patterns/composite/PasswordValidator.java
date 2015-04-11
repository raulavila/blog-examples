package com.raulavila.patterns.composite;

import com.google.common.collect.Lists;
import com.raulavila.patterns.composite.model.NewUserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PasswordValidator implements Validator<NewUserInfo> {

    @Override
    public List<String> validate(NewUserInfo info) {
        List<String> errors = Lists.newArrayList();

        String password = info.getPassword();

        if (StringUtils.isEmpty(password)) {
            errors.add("Password field must be populated");
        }
        
        return errors;
    }
}
