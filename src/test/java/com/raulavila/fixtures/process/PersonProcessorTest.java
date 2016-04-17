package com.raulavila.fixtures.process;

import com.raulavila.fixtures.domain.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.raulavila.fixtures.domain.PersonTestFactory.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class PersonProcessorTest {

    private PersonProcessor personProcessor = new PersonProcessor();

    @Test
    public void processRaulTraditionalFixture() throws Exception {
        Person raul = new Person();

        raul.setName("Raul");
        raul.setPhoneNumber("123455334");

        Person nextOfKin = new Person();
        nextOfKin.setName("Vanesa");
        nextOfKin.setPhoneNumber("1232433");

        raul.setNextOfKin(nextOfKin);

        Person child1 = new Person();
        child1.setName("Pixie");
        child1.setPhoneNumber("1232421");

        Person child2 = new Person();
        child2.setName("Dixie");
        child2.setPhoneNumber("1232444");

        raul.setChildren(Arrays.asList(child1, child2));

        Map<String, String> additionalDetails = new HashMap<>();
        additionalDetails.put("Favourite song", "Back in Black");

        raul.setAdditionalDetails(additionalDetails);

        String processResult = personProcessor.process(raul);

        assertThat(processResult).isEqualTo("I've processed Raul");
    }

    @Test
    public void processRaul() throws Exception {
        Person raul =
            person(
                name("Raul"),
                phoneNumber("123455334"),
                nextOfKin(
                    name("Vanesa"),
                    phoneNumber("1232433")
                ),
                children(
                    child(
                        name("Pixie"),
                        phoneNumber("1232421")
                    ),
                    child(
                        name("Dixie"),
                        phoneNumber("1232444")
                    )
                ),
                additionalDetails(
                    detail(
                        detailName("Favourite song"),
                        detailValue("Back in Black")
                    )
                )
            );

        String processResult = personProcessor.process(raul);
     
        assertThat(processResult).isEqualTo("I've processed Raul");
    }
}
