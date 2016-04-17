package com.raulavila.fixtures.process;

import com.raulavila.fixtures.domain.Person;

public class PersonProcessor {

    public String process(Person person) {
        String output;

        switch (person.getName()) {
            case "Raul":
                output = "I've processed Raul";
                break;
            case "John":
                output = "I've processed John";
                break;
            default:
                output = "I don't know what to do with this person";
        }

        return output;
    }
}
