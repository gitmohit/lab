package lab.mohit.practiceProblem.parkingLot.impl;

import lab.mohit.practiceProblem.parkingLot.iface.IDisplay;
import lab.mohit.practiceProblem.parkingLot.iface.IDisplayObservable;
import lab.mohit.practiceProblem.parkingLot.iface.IStats;

import java.util.ArrayList;
import java.util.List;

public class StatsObservable implements IDisplayObservable {
    List<IDisplay> displays;
    IStats stats;

    public StatsObservable() {
        this.displays = new ArrayList<>();
    }

    @Override
    public void registerDisplay(IDisplay display) {
        displays.add(display);
    }

    @Override
    public void removeDisplay(IDisplay display) {
        displays.remove(display);
    }

    public void update(IStats stats) {
        this.stats = stats;
        notifyDisplay();
    }

    @Override
    public void notifyDisplay() {
        for (IDisplay display : displays) {
            display.update(stats);
        }
    }
}
