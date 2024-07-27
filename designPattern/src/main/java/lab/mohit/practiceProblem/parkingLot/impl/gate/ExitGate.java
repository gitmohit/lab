package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;
import lab.mohit.practiceProblem.parkingLot.impl.users.ParkingAssistant;

public class ExitGate extends Gate {

    public ExitGate(String id, ParkingAssistant assistant) {
        super(id, assistant);
    }

    public void validateTicket(ParkingTicket parkingTicket) {
        System.out.println("For vehicle" +  parkingTicket.getVehicle().getId() + " Exit is " + ((parkingTicket.getPaymentStatus() == PaymentStatus.SUCCESS) ? " granted " : " not possible unless you pay the parking fee"));
    }

}
