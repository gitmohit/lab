package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

public class LightOffCommand implements ICommand {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {;
        this.light.off();
        System.out.println("Light is off!");
    }
}
