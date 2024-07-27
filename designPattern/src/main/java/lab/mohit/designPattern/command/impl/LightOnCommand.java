package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

public class LightOnCommand implements ICommand {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
        System.out.println("Light is on!");
    }
}
