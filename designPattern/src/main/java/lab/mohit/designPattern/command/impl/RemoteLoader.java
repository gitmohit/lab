package lab.mohit.designPattern.command.impl;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(2);

        Light light = new Light();
        GarbageDoor garbageDoor = new GarbageDoor();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        GarbageDoorOpenCommand garbageDoorOpenCommand = new GarbageDoorOpenCommand(garbageDoor);
        GarbageDoorShutCommand garbageDoorShutCommand = new GarbageDoorShutCommand(garbageDoor);
        remoteControl.setCommand(0, light::on, light::off);
        remoteControl.setCommand(1, garbageDoorOpenCommand, garbageDoorShutCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPressed(0);
    }
}
