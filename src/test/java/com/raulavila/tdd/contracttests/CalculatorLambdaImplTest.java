package com.raulavila.tdd.contracttests;

public class CalculatorLambdaImplTest extends CalculatorContract{
    @Override
    protected Calculator getCalculatorImpl() {
        return new CalculatorLambdaImpl();
    }
}
