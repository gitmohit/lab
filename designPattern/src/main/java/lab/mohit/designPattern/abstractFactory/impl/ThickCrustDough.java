package lab.mohit.designPattern.abstractFactory.impl;

import lab.mohit.designPattern.abstractFactory.iface.IProdDough;

public class ThickCrustDough implements IProdDough {
    public ThickCrustDough() {
        System.out.println("Using thick crust");
    }
}
