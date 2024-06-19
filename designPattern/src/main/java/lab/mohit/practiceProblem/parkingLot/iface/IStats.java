package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;

public interface IStats {
    void incrementAvailability(ParkingSlotType parkingSlotType);
    void decrementAvailability(ParkingSlotType parkingSlotType);
}
