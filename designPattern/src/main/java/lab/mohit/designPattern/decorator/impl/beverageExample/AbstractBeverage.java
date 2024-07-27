package lab.mohit.designPattern.decorator.impl.beverageExample;

public abstract class AbstractBeverage {
    public static String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double getCost();
}
