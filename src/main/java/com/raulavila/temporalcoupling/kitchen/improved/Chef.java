package com.raulavila.temporalcoupling.kitchen.improved;

import com.google.common.collect.Lists;
import com.raulavila.temporalcoupling.kitchen.model.Ingredient;

public class Chef {
    public void cookPaella() {
        Dish dish = new DishImpl(
                "paella",
                Lists.newArrayList(
                        new Ingredient("rice"),
                        new Ingredient("chicken"),
                        new Ingredient("peas")
                ));

        dish.cook();
        dish.serve();
    }
}
