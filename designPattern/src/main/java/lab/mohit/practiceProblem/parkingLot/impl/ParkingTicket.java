package lab.mohit.practiceProblem.parkingLot.impl;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.iface.IParkingSlot;

import java.time.LocalDateTime;

public class ParkingTicket {
    private static int TICKET_COUNT = 1;
    String Id;
    Vehicle vehicle;
    IParkingSlot parkingSlot;
    PaymentStatus paymentStatus;
    LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle, IParkingSlot parkingSlot) {
        this.Id = "Ticket-Id-" + TICKET_COUNT++;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getId() {
        return Id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public IParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
