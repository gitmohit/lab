package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.iface.ICommand;
import lab.mohit.practiceProblem.parkingLot.iface.IGate;

public class GateOpenCommand implements ICommand {
    IGate gate;

    public GateOpenCommand(IGate gate) {
        this.gate = gate;
    }


    @Override
    public void execute() {
        gate.open();
    }
}
