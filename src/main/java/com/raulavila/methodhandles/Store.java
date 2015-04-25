package com.raulavila.methodhandles;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Store {

    private List<Item> items = Lists.newArrayList();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public int size() {
        return items.size();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public String toString() {
        return "Store{" +
                "items=" + items +
                '}';
    }
}
