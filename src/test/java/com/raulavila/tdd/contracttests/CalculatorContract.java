package com.raulavila.tdd.contracttests;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public abstract class CalculatorContract {

    private Calculator calculator;

    protected abstract Calculator getCalculatorImpl();

    @Before
    public void setup() {
        calculator = getCalculatorImpl();
    }

    @Test
    public void shouldReturnZero_GivenEmptyString() throws Exception {
        assertThat(calculator.getSumFor("")).isEqualTo(0);
    }

    @Test
    public void shouldReturnZero_GivenZeros() throws Exception {
        assertThat(calculator.getSumFor("0,0")).isEqualTo(0);
    }

    @Test
    public void shouldReturnTheNumber_GivenOneAddend() throws Exception {
        assertThat(calculator.getSumFor("2")).isEqualTo(2);
    }

    @Test
    public void shouldReturnTheCorrectSum_GivenTwoAddend() throws Exception {
        assertThat(calculator.getSumFor("1,2")).isEqualTo(3);
    }
}
