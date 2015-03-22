package com.raulavila.dependencies.dip.withdip;

import java.math.BigDecimal;

public class BigDecimalCalculator {

    public BigDecimal add(BigDecimal operator1,
                          BigDecimal operator2) {
        BigDecimal result = BigDecimal.ZERO;
        result = result.add(operator1);
        result = result.add(operator2);
        return result;
    }

    public BigDecimal multiply(BigDecimal operator1,
                          BigDecimal operator2) {
        BigDecimal result = BigDecimal.ONE;
        result = result.multiply(operator1);
        result = result.multiply(operator2);
        return result;
    }
    
}
