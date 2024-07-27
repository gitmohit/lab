package lab.mohit.practiceProblem.parkingLot;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.enums.ParkingSlotType;
import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.enums.PaymentType;
import lab.mohit.practiceProblem.parkingLot.iface.IParkingSlot;
import lab.mohit.practiceProblem.parkingLot.impl.GateDisplay;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;
import lab.mohit.practiceProblem.parkingLot.impl.gate.EntryGate;
import lab.mohit.practiceProblem.parkingLot.impl.gate.ExitGate;
import lab.mohit.practiceProblem.parkingLot.impl.gate.GateController;
import lab.mohit.practiceProblem.parkingLot.impl.parkingSlots.ParkingSlot;
import lab.mohit.practiceProblem.parkingLot.impl.parkingSlots.ParkingSlotManager;
import lab.mohit.practiceProblem.parkingLot.impl.payment.ParkingFeeCalculator;
import lab.mohit.practiceProblem.parkingLot.impl.payment.PaymentController;
import lab.mohit.practiceProblem.parkingLot.impl.payment.PaymentFactory;
import lab.mohit.practiceProblem.parkingLot.impl.users.ParkingAssistant;


public class ParkingArea {
    String Id;
    String name;
    ParkingSlotManager parkingSlotManager;
    PaymentController paymentController;
    GateController gateController;

    public ParkingArea(String id, String name) {
        Id = id;
        this.name = name;
        this.parkingSlotManager = ParkingSlotManager.getInstance();
        this.paymentController = new PaymentController(new PaymentFactory(), new ParkingFeeCalculator());
        this.gateController = new GateController();
        initSlots();
        intiEntryExit();
    }

    private void initSlots() {
        int slotIdCount = 1;
        for (int i= 0; i<10; i++) {
            parkingSlotManager.addSlot(new ParkingSlot("Slot-ID " + slotIdCount++, true, ParkingSlotType.SMALL));
            parkingSlotManager.addSlot(new ParkingSlot("Slot-ID " + slotIdCount++, true, ParkingSlotType.MEDIUM));
            parkingSlotManager.addSlot(new ParkingSlot("Slot-ID " + slotIdCount++, true, ParkingSlotType.LARGE));
        }
    }
    private void intiEntryExit() {
        gateController.addEntryGate(new EntryGate("Entry-ID-1", new ParkingAssistant()));
        parkingSlotManager.registerDisplay(new GateDisplay("Display-ID-1"));
        gateController.addEntryGate(new EntryGate("Entry-ID-2", new ParkingAssistant()));
        parkingSlotManager.registerDisplay(new GateDisplay("Display-ID-2"));
        gateController.addExitGate(new ExitGate("Exit-ID-1", new ParkingAssistant()));
        gateController.addExitGate(new ExitGate("Exit-ID-2", new ParkingAssistant()));

    }

    ParkingTicket parkVehicle(String entryId, Vehicle vehicle) throws Exception {
        ParkingSlotType slotType;
        switch (vehicle.getVehicleType()) { // TODO: Better Solution
            case SMALL -> {
                slotType = ParkingSlotType.SMALL;
            } case MEDIUM ->  {
                slotType = ParkingSlotType.MEDIUM;
            }default ->  {
                slotType = ParkingSlotType.LARGE;
            }

        }
        IParkingSlot parkingSlot = parkingSlotManager.getAvailableParkingSlot(slotType);
        parkingSlotManager.reserveSlot(vehicle, parkingSlot);
        return gateController.getEntryGate(entryId).getTicket(vehicle, parkingSlot);
    }

    public ParkingTicket payParkingFee(ParkingTicket parkingTicket, PaymentType paymentType) {
        PaymentStatus paymentStatus = paymentController.makePayment(parkingTicket, paymentType);
        parkingTicket.setPaymentStatus(paymentStatus);
        return parkingTicket;
    }

    public void unParkVehicle(String exitGateId, ParkingTicket parkingTicket) {
        IParkingSlot parkingSlot = parkingTicket.getParkingSlot();
        parkingSlotManager.freeSlot(parkingSlot);
        gateController.getExitGate(exitGateId).validateTicket(parkingTicket);
    }
}
