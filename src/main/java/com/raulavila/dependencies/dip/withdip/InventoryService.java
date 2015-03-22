package com.raulavila.dependencies.dip.withdip;

import com.raulavila.dependencies.dip.Item;

import java.math.BigDecimal;
import java.util.List;

public class InventoryService {

    private final ItemDAO itemDAO;
    private final BigDecimalCalculator bigDecimalCalculator;

    public InventoryService(ItemDAO itemDAO,
                            BigDecimalCalculator bigDecimalCalculator) {
        this.itemDAO = itemDAO;
        this.bigDecimalCalculator = bigDecimalCalculator;
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
        BigDecimal quantity = BigDecimal.valueOf(item.getQuantity());

        BigDecimal amountItem = bigDecimalCalculator.multiply(price, quantity);
        totalAmount = bigDecimalCalculator.add(totalAmount, amountItem);
                
        return totalAmount;
    }
}
