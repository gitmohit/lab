package lab.mohit.designPattern.iterator.impl;

import lab.mohit.designPattern.iterator.iface.IMenu;

public class MenuTestDrive {

    public static void main(String[] args) {
        IMenu<MenuItem> pancakeHouseMenu = new PancakeHouseMenu();
        IMenu<MenuItem> dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
