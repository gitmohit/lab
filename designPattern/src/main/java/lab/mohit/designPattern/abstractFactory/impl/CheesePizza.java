package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IPizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private final IPizzaIngredientFactory pizzaIngredientFactory;

    CheesePizza(IPizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
        prepare();
    }
    @Override
    void prepare() {
        this.dough = pizzaIngredientFactory.createDough();
        this.cheese = pizzaIngredientFactory.createCheese();
        this.clams = pizzaIngredientFactory.createClams();
        this.sauce = pizzaIngredientFactory.createSauce();
    }
}
