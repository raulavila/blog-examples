package com.raulavila.patterns.composite;

import com.google.common.collect.Lists;
import com.raulavila.patterns.composite.model.NewUserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class NameValidator implements Validator<NewUserInfo> {
    
    @Override
    public List<String> validate(NewUserInfo info) {
        List<String> errors = Lists.newArrayList();

        String name = info.getName();
        String surname = info.getSurname();

        if (StringUtils.isEmpty(name)) {
            errors.add("Name must be populated");
        }
        
        if (StringUtils.isEmpty(surname)) {
            errors.add("Surname must be populated");
        }
        
        return errors;
    }
}
