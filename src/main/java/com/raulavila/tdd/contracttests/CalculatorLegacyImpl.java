package com.raulavila.tdd.contracttests;

import org.apache.commons.lang3.StringUtils;

public class CalculatorLegacyImpl implements Calculator {
    @Override
    public long getSumFor(String expression) {
        if(StringUtils.isEmpty(expression))
            return 0;

        String[] addends = expression.split(",");

        long result = 0;

        for (String addend : addends) {
            int number = Integer.parseInt(addend);
            result = result + number;
        }

        return result;
    }
}
