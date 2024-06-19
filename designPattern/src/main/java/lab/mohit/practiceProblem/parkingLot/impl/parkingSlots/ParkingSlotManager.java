package lab.mohit.practiceProblem.parkingLot.impl.parkingSlots;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;
import lab.mohit.practiceProblem.parkingLot.iface.*;
import lab.mohit.practiceProblem.parkingLot.impl.AvailabilityStats;

import java.util.*;

public class ParkingSlotManager implements IParkingSlotManager, IDisplayObservable{ // can have another implementation for DB management , this is for in memory
    Map<ParkingSlotType, Map<String, IParkingSlot>> parkingSlotsBySlotType;
    Map<ParkingSlotType, Queue<String>> availableSlotIdBySlotType;
    List<IDisplay> displays;
    IStats availabilityStats;

    private static ParkingSlotManager slotManagerInstance;
    public static ParkingSlotManager getInstance() {
        if (slotManagerInstance == null) {
            synchronized (ParkingSlotManager.class) {
                if (slotManagerInstance == null) {
                    slotManagerInstance = new ParkingSlotManager();
                }
            }
        }
        return slotManagerInstance;
    }

    private ParkingSlotManager() {
        this.parkingSlotsBySlotType = new HashMap<>();
        this.availableSlotIdBySlotType = new HashMap<>();
        this.displays = new ArrayList<>();
        this.availabilityStats = AvailabilityStats.getAvailabilityStats();
    }

    @Override
    public void addSlot(IParkingSlot parkingSlot) {
        parkingSlotsBySlotType.computeIfAbsent(parkingSlot.getSlotType(), f -> new HashMap<>()).putIfAbsent(parkingSlot.getId(), parkingSlot);
        if (parkingSlot.isAvailable()) {
            availableSlotIdBySlotType.computeIfAbsent(parkingSlot.getSlotType(), f -> new LinkedList<>()).add(parkingSlot.getId());
        }
        availabilityStats.incrementAvailability(parkingSlot.getSlotType());
    }

    @Override
    public void addSlots(List<IParkingSlot> parkingSlots) {
        for (IParkingSlot parkingSlot : parkingSlots) {
            addSlot(parkingSlot);
        }
    }

    @Override
    public IParkingSlot getAvailableParkingSlot(ParkingSlotType slotType) throws Exception {
        if (hasAvailableSlot(slotType)) {
            return parkingSlotsBySlotType.get(slotType).get(availableSlotIdBySlotType.get(slotType).poll());
        }
        throw new Exception("No slot available");
    }

    @Override
    public boolean hasAvailableSlot(ParkingSlotType slotType) {
        if (availableSlotIdBySlotType.containsKey(slotType)) {
            Queue<String> availableSlotQueue = availableSlotIdBySlotType.get(slotType);
            return !availableSlotQueue.isEmpty();
        }
        return false;
    }

    @Override
    public void reserveSlot(Vehicle vehicle, IParkingSlot parkingSlot) {
        parkingSlot.setAvailable(false);
        availabilityStats.decrementAvailability(parkingSlot.getSlotType());
        notifyDisplay();
    }

    @Override
    public void freeSlot(IParkingSlot parkingSlot) {
        parkingSlot.setAvailable(true);
        availableSlotIdBySlotType.get(parkingSlot.getSlotType()).offer(parkingSlot.getId());
        availabilityStats.incrementAvailability(parkingSlot.getSlotType());
        notifyDisplay();
    }


    @Override
    public void registerDisplay(IDisplay display) {
        displays.add(display);
    }

    @Override
    public void removeDisplay(IDisplay display) {
        displays.remove(display);
    }

    @Override
    public void notifyDisplay() {
        for (IDisplay display : displays) {
            display.update(availabilityStats);
        }
    }
}
