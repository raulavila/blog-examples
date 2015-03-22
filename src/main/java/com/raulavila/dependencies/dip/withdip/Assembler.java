package com.raulavila.dependencies.dip.withdip;

import java.math.BigDecimal;

public class Assembler {

    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAOImpl();
        BigDecimalCalculator bigDecimalCalculator = new BigDecimalCalculator();
        InventoryService inventoryService = new InventoryService(itemDAO, bigDecimalCalculator);
        BigDecimal totalAmount = inventoryService.getTotalAmount();
        System.out.println(totalAmount);
    }
    
}
