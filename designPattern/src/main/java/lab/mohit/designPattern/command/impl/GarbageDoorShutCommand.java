package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

public class GarbageDoorShutCommand implements ICommand {
    private final GarbageDoor garbageDoor;

    public GarbageDoorShutCommand(GarbageDoor garbageDoor) {
        this.garbageDoor = garbageDoor;
    }

    @Override
    public void execute() {
        this.garbageDoor.shut();
        System.out.println("GarbageDoor is off");
    }
}
