package lab.mohit.designPattern.decorator.impl.beverageExample;

public class SugarCondiment extends AbstractCondimentDecorator {

    private final AbstractBeverage abstractBeverage;
    public SugarCondiment(AbstractBeverage abstractBeverage) {
        this.abstractBeverage = abstractBeverage;
    }
    @Override
    public double getCost() {
        return 5.0 + abstractBeverage.getCost();
    }

    @Override
    public String getDescription() {
        return abstractBeverage.getDescription() + " Sugar";
    }
}
