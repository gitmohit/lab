package lab.mohit.practiceProblem.parkingLot;

import lab.mohit.practiceProblem.parkingLot.abstrct.Vehicle;
import lab.mohit.practiceProblem.parkingLot.enums.PaymentType;
import lab.mohit.practiceProblem.parkingLot.enums.VehicleType;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;

public class ParkingAreaTest {
    public static void main(String[] args) throws Exception {
        Vehicle car = new Vehicle("V-ID-1", VehicleType.SMALL);
        Vehicle truck = new Vehicle("V-ID-2", VehicleType.LARGE);
        ParkingArea parkingArea = new ParkingArea("P-ID-1", "Test Parking");
        ParkingTicket carTicket = parkingArea.parkVehicle("Entry-ID-1", car);
        ParkingTicket truckTicket = parkingArea.parkVehicle("Entry-ID-2", truck);
        parkingArea.payParkingFee(carTicket, PaymentType.UPI);
        parkingArea.payParkingFee(truckTicket, PaymentType.CASH);
        parkingArea.unParkVehicle("Exit-ID-1", carTicket);
        parkingArea.unParkVehicle("Exit-ID-2", truckTicket);
    }
}
