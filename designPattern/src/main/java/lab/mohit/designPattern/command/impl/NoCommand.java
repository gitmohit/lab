package lab.mohit.designPattern.command.impl;

import lab.mohit.designPattern.command.iface.ICommand;

public class NoCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("NoCommand!");
    }
}
