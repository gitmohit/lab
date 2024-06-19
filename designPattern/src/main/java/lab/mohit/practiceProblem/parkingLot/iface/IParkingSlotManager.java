package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;
import lab.mohit.practiceProblem.parkingLot.impl.parkingSlots.ParkingSlot;

import java.util.List;

public interface IParkingSlotManager {
    void addSlot(IParkingSlot parkingSlot);

    void addSlots(List<IParkingSlot> parkingSlots);

    IParkingSlot getAvailableParkingSlot(ParkingSlotType slotType) throws Exception;

    boolean hasAvailableSlot(ParkingSlotType slotType);

    void reserveSlot(Vehicle vehicle, IParkingSlot parkingSlot);
    void freeSlot(IParkingSlot parkingSlot);
}
