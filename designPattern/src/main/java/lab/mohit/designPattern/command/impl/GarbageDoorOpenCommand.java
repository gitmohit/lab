package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

public class GarbageDoorOpenCommand implements ICommand {
    private final GarbageDoor garbageDoor;

    public GarbageDoorOpenCommand(GarbageDoor garbageDoor) {
        this.garbageDoor = garbageDoor;
    }

    @Override
    public void execute() {
        this.garbageDoor.open();
        System.out.println("GarbageDoor is open!");
    }
}
