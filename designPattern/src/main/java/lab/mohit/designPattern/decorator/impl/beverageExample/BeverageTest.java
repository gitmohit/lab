package lab.mohit.designPattern.decorator.impl.beverageExample;

public class BeverageTest {
    public static void main(String[] args) {
        AbstractBeverage abstractBeverage = new FilterCoffee();

        // Coffee
        AbstractBeverage coffee = new MilkCondiment(abstractBeverage);
        coffee = new SugarCondiment(coffee);
        System.out.println(coffee.getDescription() + " " + coffee.getCost());

        // Tea
        AbstractBeverage abstractBeverage1 = new TeaLiquor();
        AbstractBeverage tea = new MilkCondiment(abstractBeverage1);
        tea = new CardamomCondiment(tea);
        tea = new SugarCondiment(tea);
        System.out.println(tea.getDescription() + " " + tea.getCost());

    }
}
