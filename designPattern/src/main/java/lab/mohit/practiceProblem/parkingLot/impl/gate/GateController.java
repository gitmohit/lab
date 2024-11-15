package lab.mohit.practiceProblem.parkingLot.impl.gate;

import java.util.HashMap;
import java.util.Map;

public class GateController {
    Map<String, EntryGate> entryGateById;
    Map<String, ExitGate> exitGateById;

    public GateController() {
        entryGateById = new HashMap<>();
        exitGateById = new HashMap<>();
    }

    public void addEntryGate(EntryGate entryGate) {
        entryGateById.put(entryGate.Id, entryGate);
    }

    public EntryGate getEntryGate(String entryGateId) {
        return entryGateById.get(entryGateId);
    }

    public void addExitGate(ExitGate exitGate) {
        exitGateById.put(exitGate.Id, exitGate);
    }

    public ExitGate getExitGate(String exitGateId) {
        return exitGateById.get(exitGateId);
    }


}
