package com.raulavila.patterns.composite;

import com.raulavila.patterns.composite.model.NewUserInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AgeValidatorTest {

    private AgeValidator ageValidator = new AgeValidator();

    @Mock
    private NewUserInfo newUserInfo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdult() throws Exception {
        when(newUserInfo.getAge()).thenReturn(20);

        List<String> errors = ageValidator.validate(newUserInfo);
        assertThat(errors).isEmpty();
    }

    @Test
    public void testChild() throws Exception {
        when(newUserInfo.getAge()).thenReturn(15);

        List<String> errors = ageValidator.validate(newUserInfo);
        assertThat(errors).hasSize(1);
        assertThat(errors).contains("Age must be >= 18");
    }
}