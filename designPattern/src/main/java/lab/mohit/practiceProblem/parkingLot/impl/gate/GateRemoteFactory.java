package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.iface.IGate;

public class GateRemoteFactory {
    public GateRemoteControl getGateRemoteControl(IGate gate) {
        GateRemoteControl remoteControl = new GateRemoteControl(2);
        GateOpenCommand open = new GateOpenCommand(gate);
        GateCloseCommand close = new GateCloseCommand(gate);
        remoteControl.setCommand(0, open, close);
        return remoteControl;
    }
}
