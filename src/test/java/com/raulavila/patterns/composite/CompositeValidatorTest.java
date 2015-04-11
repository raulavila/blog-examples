package com.raulavila.patterns.composite;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CompositeValidatorTest {

    private CompositeValidator<Object> compositeValidator;

    @Mock
    private Validator<Object> validator1;
    @Mock
    private Validator<Object> validator2;

    @Mock
    private Object info;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<Validator<Object>> validators =
                Lists.newArrayList(validator1, validator2);
        
        compositeValidator = new CompositeValidator<Object>(validators);

        when(validator1.validate(info)).thenReturn(Lists.newArrayList("error1"));
        when(validator2.validate(info)).thenReturn(Lists.newArrayList("error2"));

    }

    @Test
    public void testComposite() throws Exception {
        List<String> errors = compositeValidator.validate(info);

        verify(validator1).validate(info);
        verify(validator2).validate(info);

        assertThat(errors).containsExactly("error1", "error2");
    }
}