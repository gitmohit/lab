package lab.mohit.designPattern.abstractFactory.impl;

public class PizzaStoreTest {
    public static void main(String[] args) throws InterruptedException {
        DominosPizzaStore dominosPizzaStore = new DominosPizzaStore();
        dominosPizzaStore.orderPizza("CHEESE");
        Thread.sleep(2000);
        dominosPizzaStore.orderPizza("CLAM");
    }
}
