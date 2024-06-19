package lab.mohit.designPattern.command.impl;

import java.util.concurrent.atomic.AtomicBoolean;

/* Vendor Class*/
public class GarbageDoor {
    private volatile AtomicBoolean isOpen;

    public GarbageDoor() {
        this.isOpen = new AtomicBoolean(false);
    }
    public void open() {
        this.isOpen.set(true);
    }

    public void shut() {
        this.isOpen.set(false);
    }
}
