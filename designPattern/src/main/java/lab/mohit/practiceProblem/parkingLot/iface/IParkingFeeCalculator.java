package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;

public interface IParkingFeeCalculator {
    double calculateParkingFee(ParkingTicket parkingTicket);
}
