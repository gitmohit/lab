package lab.mohit.designPattern.abstractFactory.impl;

// client of pizza factory
public abstract class PizzaStore {
    abstract Pizza createPizza(String item);
    Pizza orderPizza(String item) {
        Pizza pizza = createPizza(item);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return  pizza;
    }
}
