package lab.mohit.practiceProblem.parkingLot.impl;

import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;
import lab.mohit.practiceProblem.parkingLot.iface.IStats;

import java.util.HashMap;
import java.util.Map;

public class AvailabilityStats implements IStats {
    Map<ParkingSlotType, Integer> availabilityCountBySlotType;
    private static AvailabilityStats INSTANCE;

    public static AvailabilityStats getAvailabilityStats() {
        if (INSTANCE == null) {
            synchronized (AvailabilityStats.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AvailabilityStats();
                }
            }
        }
        return INSTANCE;
    }
    private AvailabilityStats() {
        this.availabilityCountBySlotType = new HashMap<>();
    }

    public void incrementAvailability(ParkingSlotType parkingSlotType) {
        availabilityCountBySlotType.put(parkingSlotType, availabilityCountBySlotType.getOrDefault(parkingSlotType,0)+1);

    }

    public void decrementAvailability(ParkingSlotType parkingSlotType) {
        availabilityCountBySlotType.put(parkingSlotType, availabilityCountBySlotType.getOrDefault(parkingSlotType,0)-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Availability Stats : ");
        for (Map.Entry<ParkingSlotType, Integer> entry : availabilityCountBySlotType.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" : ");
            sb.append(entry.getValue());
            sb.append("\t");
        }
        sb.append("]");
        return sb.toString();
    }
}
