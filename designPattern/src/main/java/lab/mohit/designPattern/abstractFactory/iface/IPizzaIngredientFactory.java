package lab.mohit.designPattern.abstractFactory.iface;

public interface IPizzaIngredientFactory {
    IProdDough createDough();
    IProdSauce createSauce();
    IProdCheese createCheese();
    IProdClams createClams();
}
