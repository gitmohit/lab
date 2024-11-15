package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.iface.ICommand;

public class GateRemoteControl {
    ICommand[] onCommands;
    ICommand[] offCommands;


    public GateRemoteControl(int slots) {
        this.onCommands = new ICommand[slots];
        this.offCommands = new ICommand[slots];
    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = onCommand;
    }

    public void onButtonWasPressed(int slot) {
        this.onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        this.offCommands[slot].execute();
    }

}
