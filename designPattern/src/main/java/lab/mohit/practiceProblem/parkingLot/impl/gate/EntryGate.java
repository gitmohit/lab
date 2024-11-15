package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.iface.IParkingSlot;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;
import lab.mohit.practiceProblem.parkingLot.impl.users.ParkingAssistant;

public class EntryGate extends Gate {

    public EntryGate(String id, ParkingAssistant assistant) {
        super(id, assistant);
    }

    public ParkingTicket getTicket(Vehicle vehicle, IParkingSlot slot) {
        slot.setAvailable(false);
        return new ParkingTicket(vehicle, slot);
    }

}
