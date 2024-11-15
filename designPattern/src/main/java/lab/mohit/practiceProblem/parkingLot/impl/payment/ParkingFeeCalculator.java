package lab.mohit.practiceProblem.parkingLot.impl.payment;

import lab.mohit.practiceProblem.parkingLot.iface.IParkingFeeCalculator;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;

public class ParkingFeeCalculator implements IParkingFeeCalculator {
    @Override
    public double calculateParkingFee(ParkingTicket parkingTicket) {
        System.out.println("Returning parking fee for " + parkingTicket.getId());
        return 10.0;
    }
}
