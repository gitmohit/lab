package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IProdDough;

public class ThinCrustDough implements IProdDough {
    public ThinCrustDough() {
        System.out.println("Using Thin Crust");
    }
}
