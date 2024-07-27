package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.IMenu;
import lab.mohit.designPattern.iterator.iface.Iterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu implements IMenu<MenuItem> {
    private final List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<>();
        addItem("Regular pancake breakfast", "Pancakes with fried eggs, sausage", false, 3.99);
        addItem("K&B's pancake breakfast", "Pancakes with scrambled eggs, toast", false, 3.49);
        addItem("Waffles", "Waffles with your choice of blueberries or strawberries", true, 2.99);
        addItem("Blueberry pancake", "Waffles with blueberries", true, 2.49);

    }

    public void addItem(String name, String description, boolean isVegetarian, double price) {
        menuItems.add(new MenuItem(name, description, isVegetarian, price));
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
