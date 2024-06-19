package lab.mohit.designPattern.iterator.impl;

public class MenuItem {
    private final String name;
    private final String description;
    private final boolean isVegetarian;
    private final double price;

    public MenuItem(String name, String description, boolean isVegetarian, double price) {
        this.name = name;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[MenuItem : ");
        sb.append(name);
        sb.append("]\n Description:\n");
        sb.append(description);
        sb.append(isVegetarian ? "\nVegetarian\n" : "\nNon Vegetarian\n");
        sb.append("Price : ");
        sb.append(price);
        sb.append("\n");
        return sb.toString();
    }
}
