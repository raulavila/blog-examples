package com.raulavila.fixtures.domain;

import com.google.common.collect.Maps;

import java.util.*;

public class PersonTestFactory {

    public static Person person(
            String name,
            String phoneNumber,
            Person nextOfKin,
            List<Person> children,
            Map<String, String> additionalDetails) {
        
        Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        person.setNextOfKin(nextOfKin);
        person.setChildren(children);
        person.setAdditionalDetails(additionalDetails);
        return person;
    }

    public static Person person(
            String name,
            String phoneNumber) {

        Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phoneNumber);
        return person;
    }

    public static String name(String name) {
        return name;
    }

    public static String phoneNumber(String phoneNumber) {
        return phoneNumber;
    }

    public static Person nextOfKin(String name, String phoneNumber) {
        return person(name, phoneNumber);
    }

    public static List<Person> children(Person... child) {
        return Arrays.asList(child);
    }

    public static Person child(String name, String phoneNumber) {
        return person(name, phoneNumber);
    }

    public static Map<String, String> additionalDetails(
            Map.Entry<String, String>...entries) {
        Map<String, String> map = new HashMap<>();

        for (Map.Entry<String, String> entry : entries) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }

    public static Map.Entry<String, String> detail(String key, String value) {
        return Maps.immutableEntry(key, value);
    }

    public static String detailName(String name) {
        return name;
    }

    public static String detailValue(String value) {
        return value;

    }
}
