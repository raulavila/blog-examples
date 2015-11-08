package com.raulavila.tdd.contracttests;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class CalculatorLambdaImpl implements Calculator {
    
    @Override
    public long getSumFor(String expression) {
        if(StringUtils.isEmpty(expression))
            return 0;

        String[] addends = expression.split(",");

        return Arrays.stream(addends)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
