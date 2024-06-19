package lab.mohit.designPattern.decorator.impl.beverageExample;

public class TeaLiquor extends AbstractBeverage {

    @Override
    public String getDescription() {
        return "Tea liquor";
    }
    @Override
    public double getCost() {
        return 10.00;
    }
}
