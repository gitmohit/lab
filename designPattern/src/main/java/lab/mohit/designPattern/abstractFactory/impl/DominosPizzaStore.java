package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IPizzaIngredientFactory;

public class DominosPizzaStore extends PizzaStore {
    IPizzaIngredientFactory pizzaIngredientFactory;

    public DominosPizzaStore() {
        this.pizzaIngredientFactory = new DominosPizzaIngredientFactory();
    }
    @Override
    Pizza createPizza(String item) {
        if (item.equals("CHEESE")) {
            return new CheesePizza(pizzaIngredientFactory);
        } else if (item.equals("CLAM")) {
            return new ClamPizza(pizzaIngredientFactory);
        }
        return null;
    }
}
