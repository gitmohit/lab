package lab.mohit.practiceProblem.parkingLot.impl;

import lab.mohit.practiceProblem.parkingLot.iface.IDisplay;
import lab.mohit.practiceProblem.parkingLot.iface.IStats;

public class GateDisplay implements IDisplay {
    String id;
    IStats stats;

    public GateDisplay(String id) {
        this.id = id;
    }

    @Override
    public void displayAvailability() {
        System.out.println(stats);
    }

    @Override
    public void update(IStats stats) {
        this.stats = stats;
        displayAvailability();
    }
}
