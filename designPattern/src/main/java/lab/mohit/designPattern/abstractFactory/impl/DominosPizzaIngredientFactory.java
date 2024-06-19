package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.*;

public class DominosPizzaIngredientFactory implements IPizzaIngredientFactory {
    @Override
    public IProdDough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public IProdSauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public IProdCheese createCheese() {
        return new PlainCheese();
    }

    @Override
    public IProdClams createClams() {
        return new FreshClams();
    }
}
