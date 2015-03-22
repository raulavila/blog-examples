package com.raulavila.dependencies.dip.withoutdip;

import com.google.common.collect.Lists;
import com.raulavila.dependencies.dip.Item;

import java.math.BigDecimal;
import java.util.List;

public class ItemDAO {
    public final List<Item> items;

    public ItemDAO() {
        items = Lists.newArrayList(
                new Item("item1", BigDecimal.valueOf(10.00), 2),
                new Item("item1", BigDecimal.valueOf(20.00), 1),
                new Item("item1", BigDecimal.valueOf(30.00), 3));
    }

    public List<Item> getItems() {
        return items;
    }
}
