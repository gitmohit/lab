package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.IMenu;
import lab.mohit.designPattern.iterator.iface.Iterator;

import java.awt.*;

public class Waitress {
    private IMenu<MenuItem> pancakeHouseMenu;
    private IMenu<MenuItem> dinerMenu;

    public Waitress(IMenu<MenuItem> pancakeHouseMenu, IMenu<MenuItem> dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator<MenuItem> pancakeMenuIterator = pancakeHouseMenu.createIterator();
        Iterator<MenuItem> dinerMenuIterator = dinerMenu.createIterator();
        printMenu(pancakeMenuIterator);
        System.out.println("\n\n----------------Done With PancakeMenu---------------\n\n");
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
