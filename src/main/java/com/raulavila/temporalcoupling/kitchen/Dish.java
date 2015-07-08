package com.raulavila.temporalcoupling.kitchen;

import com.raulavila.temporalcoupling.kitchen.model.Ingredient;

public interface Dish {
    void addIngredient(Ingredient ingredient);
    public void mix();
    public void cook();
    public void serve();
}
