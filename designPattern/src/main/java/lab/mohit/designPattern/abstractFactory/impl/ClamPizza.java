package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IPizzaIngredientFactory;

import java.io.Serializable;

public class ClamPizza extends Pizza {
    private final IPizzaIngredientFactory pizzaIngredientFactory;

    ClamPizza(IPizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
        prepare();
    }
    @Override
    void prepare() {
//        Serializable
        this.dough = pizzaIngredientFactory.createDough();
        this.cheese = pizzaIngredientFactory.createCheese();
        this.clams = pizzaIngredientFactory.createClams();
        this.sauce = pizzaIngredientFactory.createSauce();
    }
}
