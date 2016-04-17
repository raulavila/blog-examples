package com.raulavila.fixtures.domain;

import java.util.List;
import java.util.Map;

public class Person {

    private String name;
    private String phoneNumber;
    private Person nextOfKin;
    private List<Person> children;
    private Map<String, String> additionalDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(Person nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Map<String, String> getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(Map<String, String> additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nextOfKin=" + nextOfKin +
                ", children=" + children +
                ", additionalDetails=" + additionalDetails +
                '}';
    }
}
