package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.IMenu;
import lab.mohit.designPattern.iterator.iface.Iterator;

public class DinerMenu implements IMenu<MenuItem> {
    private static final int MAX_ITEMS = 10;
    private final MenuItem[] menuItems;
    private int lastEmptyIndex;
    public DinerMenu() {
        this.menuItems = new MenuItem[MAX_ITEMS];
        this.lastEmptyIndex = 0;
        addItem("Masala Dosa", "Dosa with smashed potato and ghee roast", true, 10.49);
        addItem("Uttapam", "Onion and tomato stuffed uttapam", true, 8.49);
        addItem("Podi Idaly", "Idaly with podi masala", true, 5.49);
        addItem("Chicken Biryani", "Afgani roasted chicken Biryani", false, 20.49);
    }

    public void addItem(String name, String description, boolean isVegetarian, double price) {
        menuItems[lastEmptyIndex++] = new MenuItem(name, description, isVegetarian, price);
    }
    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
