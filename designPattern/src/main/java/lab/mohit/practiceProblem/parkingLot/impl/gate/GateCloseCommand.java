package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.iface.ICommand;
import lab.mohit.practiceProblem.parkingLot.iface.IGate;

public class GateCloseCommand implements ICommand {
    IGate gate;

    public GateCloseCommand(IGate gate) {
        this.gate = gate;
    }


    @Override
    public void execute() {
        gate.close();
    }
}
