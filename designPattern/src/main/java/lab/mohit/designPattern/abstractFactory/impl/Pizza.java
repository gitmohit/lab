package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IProdClams;
import lab.mohit.designPattern.abstractFactory.iface.IProdCheese;
import lab.mohit.designPattern.abstractFactory.iface.IProdDough;
import lab.mohit.designPattern.abstractFactory.iface.IProdSauce;

public abstract class Pizza {
    String name;
    IProdDough dough;
    IProdSauce sauce;
    IProdCheese cheese;
    IProdClams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

}
