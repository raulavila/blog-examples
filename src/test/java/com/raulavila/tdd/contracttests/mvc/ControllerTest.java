package com.raulavila.tdd.contracttests.mvc;

import com.raulavila.tdd.contracttests.Calculator;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Test
    public void evaluateUserExpression() throws Exception {
        //Given
        Display display = mock(Display.class);
        Calculator calculator = mock(Calculator.class);
        Controller controller = new Controller(display, calculator);
        when(calculator.getSumFor("1,2")).thenReturn(3L);

        //When
        controller.onExpression("1,2");

        //Then
        verify(display).showResult(3);
    }

    private interface Display {
        Void showResult(long result);
    }

    private class Controller {
        private final Display display;
        private final Calculator calculator;

        public Controller(Display display, Calculator calculator) {
            this.display = display;
            this.calculator = calculator;
        }

        public void onExpression(String expression) {
            long sum = calculator.getSumFor(expression);
            display.showResult(sum);
        }
    }
}
