package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

import java.util.Arrays;

public class RemoteControl {
    ICommand[] onCommands;
    ICommand[] offCommands;

    public RemoteControl(int slots) {
        this.onCommands = new ICommand[slots];
        this.offCommands = new ICommand[slots];
        ICommand noCommand = new NoCommand();
        Arrays.fill(onCommands, noCommand);
        Arrays.fill(offCommands, noCommand);
    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        this.onCommands[slot] = onCommand;
        this.offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        this.onCommands[slot].execute();
    }

    public void offButtonWasPressed(int slot) {
        this.offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----Remote Control----\n");
        for (int i=0; i<onCommands.length; i++) {
            sb.append("[Slot " + i + "] " + onCommands[i].getClass().getName() + " " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
