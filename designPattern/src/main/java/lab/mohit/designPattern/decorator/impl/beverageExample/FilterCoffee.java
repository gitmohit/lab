package lab.mohit.designPattern.decorator.impl.beverageExample;

public class FilterCoffee extends AbstractBeverage {

    @Override
    public String getDescription() {
        return "Filter Coffee";
    }
    @Override
    public double getCost() {
        return 10.00;
    }
}
