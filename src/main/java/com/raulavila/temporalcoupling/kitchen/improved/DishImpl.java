package com.raulavila.temporalcoupling.kitchen.improved;

import com.google.common.collect.Lists;
import com.raulavila.temporalcoupling.kitchen.model.Ingredient;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class DishImpl implements Dish {

    private final String name;
    private boolean mixed = false;
    private boolean cooked = false;
    private final List<Ingredient> ingredientList;

    public DishImpl(String name, List<Ingredient> ingredientList) {
        Validate.notEmpty(ingredientList);

        this.name = name;
        this.ingredientList = Lists.newArrayList(ingredientList);
        
        mix();
    }

    private void mix() {
        System.out.printf("%s - Mixing ingredients: %s%n", name, ingredientList.toString());
        
        mixed = true;
    }

    public void cook() {
        if(!mixed)
            throw new IllegalStateException("Ingredients are not mixed, please call mix first");
        
        System.out.printf("%s - Cooking...%n", name);
        
        cooked = true;
    }
    
    public void serve() {
        if(!cooked)
            throw new IllegalStateException("Dish is not cooked, please call cook first");
        
        System.out.printf("%s - Serving...%n", name);
        
    }
}
