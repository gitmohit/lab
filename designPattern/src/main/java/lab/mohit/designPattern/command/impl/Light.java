package lab.mohit.designPattern.command.impl;

import java.util.concurrent.atomic.AtomicBoolean;

/* Vendor Class*/
public class Light {
    private volatile AtomicBoolean isOn;

    public Light() {
        this.isOn = new AtomicBoolean(false);
    }
    public void on() {
        this.isOn.set(true);
    }

    public void off() {
        this.isOn.set(false);
    }
}
