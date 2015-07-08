package com.raulavila.temporalcoupling.kitchen;

import com.google.common.collect.Lists;
import com.raulavila.temporalcoupling.kitchen.model.Ingredient;
import org.apache.commons.lang3.Validate;

import java.util.List;

public class DishImpl implements Dish {

    private final String name;
    private boolean mixed = false;
    private boolean cooked = false;
    private final List<Ingredient> ingredientList = Lists.newArrayList();

    public DishImpl(String name) {
        this.name = name;
    }

    public void addIngredient(Ingredient ingredient) {
        Validate.notNull(ingredient);

        System.out.printf("%s - Adding ingredient %s%n", name, ingredient.getName());
        ingredientList.add(ingredient);
    }

    public void mix() {
        if(ingredientList.isEmpty())
            throw new IllegalStateException("There are no ingredients to mix");
        
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
            throw new IllegalStateException("Dish is not cooked");
        
        System.out.printf("%s - Serving...%n", name);
        
    }
}
