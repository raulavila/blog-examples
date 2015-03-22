package com.raulavila.dependencies.dip.withdip;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-beans.xml");

        InventoryService inventoryService = context.getBean("inventoryService", InventoryService.class);
        BigDecimal totalAmount = inventoryService.getTotalAmount();
        System.out.println(totalAmount);
    }
}
