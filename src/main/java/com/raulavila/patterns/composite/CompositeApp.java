package com.raulavila.patterns.composite;

import com.raulavila.patterns.composite.model.NewUserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-beans-composite.xml");

        @SuppressWarnings("unchecked")
        Validator<NewUserInfo> newInfoUserValidator = 
                context.getBean("newUserInfoValidator", Validator.class);

        NewUserInfo newUserInfo = new NewUserInfo();

        List<String> errors = newInfoUserValidator.validate(newUserInfo);

        System.out.println(errors);
    }
}
