package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;

public interface IParkingSlot {
    String getId();
    boolean isAvailable();
    void setAvailable(boolean available);
    ParkingSlotType getSlotType();
}
