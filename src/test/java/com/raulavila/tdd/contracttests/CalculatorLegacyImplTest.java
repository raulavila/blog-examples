package com.raulavila.tdd.contracttests;

public class CalculatorLegacyImplTest extends CalculatorContract {

    @Override
    protected Calculator getCalculatorImpl() {
        return new CalculatorLegacyImpl();
    }
}
