package com.raulavila.patterns.composite;

import com.google.common.collect.Lists;
import com.raulavila.patterns.composite.model.Address;
import com.raulavila.patterns.composite.model.NewUserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class AddressValidator implements Validator<NewUserInfo> {
    @Override
    public List<String> validate(NewUserInfo info) {
        List<String> errors = Lists.newArrayList();

        Address address = info.getAddress();

        if (address == null) {
            errors.add("Address can't be null");
        } else {
            errors.addAll(validateAddress(address));

        }
        
        return errors;
    }

    private List<String> validateAddress(Address address) {
        List<String> errors = Lists.newArrayList();
        
        String line1 = address.getLine1();
        String city = address.getCity();
        String postcode = address.getPostcode();

        if (StringUtils.isEmpty(line1)) {
            errors.add("Line1 must be populated");
        }

        if (StringUtils.isEmpty(city)) {
            errors.add("City must be populated");
        }

        if (StringUtils.isEmpty(postcode)) {
            errors.add("Postcode must be populated");
        }
        return errors;
    }
}
