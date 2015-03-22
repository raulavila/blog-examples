package com.raulavila.dependencies.dip.withoutdip;

import com.raulavila.dependencies.dip.Item;

import java.math.BigDecimal;
import java.util.List;

public class InventoryService {

    private ItemDAO itemDAO;

    public InventoryService() {
        itemDAO = new ItemDAO();
    }

    public BigDecimal getTotalAmount() {
        List<Item> items = itemDAO.getItems();

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Item item : items) {
            totalAmount = addItemAmountToTotal(item, totalAmount);
        }

        return totalAmount;
    }

    private BigDecimal addItemAmountToTotal(Item item, BigDecimal totalAmount) {
        BigDecimal price = item.getPrice();
        int quantity = item.getQuantity();

        BigDecimal amountItem =
                price.multiply(BigDecimal.valueOf(quantity));

        totalAmount = totalAmount.add(amountItem);
        return totalAmount;
    }

    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        BigDecimal totalAmount = inventoryService.getTotalAmount();
        System.out.println(totalAmount);
    }

}
