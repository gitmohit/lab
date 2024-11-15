package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IProdClams;

public class FrozenClams implements IProdClams {
    public FrozenClams() {
        System.out.println("Using Frozen Clams");
    }
}
