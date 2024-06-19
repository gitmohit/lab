package lab.mohit.designPattern.decorator.impl.beverageExample;

public class CardamomCondiment extends AbstractCondimentDecorator {
    private final AbstractBeverage abstractBeverage;
    public CardamomCondiment(AbstractBeverage abstractBeverage) {
        this.abstractBeverage = abstractBeverage;
    }

    @Override
    public double getCost() {
        return 2.0 + abstractBeverage.getCost();
    }

    @Override
    public String getDescription() {
        return abstractBeverage.getDescription() + " Cardamom";
    }
}
