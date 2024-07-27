package lab.mohit.practiceProblem.parkingLot.impl.parkingSlots;

import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;
import lab.mohit.practiceProblem.parkingLot.iface.IParkingSlot;

public class ParkingSlot implements IParkingSlot {
    String Id;
    boolean isAvailable;
    ParkingSlotType slotType;

    public ParkingSlot(String id, boolean isAvailable, ParkingSlotType slotType) {
        Id = id;
        this.isAvailable = isAvailable;
        this.slotType = slotType;
    }

    @Override
    public String getId() {
        return Id;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public ParkingSlotType getSlotType() {
        return slotType;
    }
}
