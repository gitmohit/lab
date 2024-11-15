package lab.mohit.practiceProblem.parkingLot.abstrct;

import lab.mohit.practiceProblem.parkingLot.enums.VehicleType;

public class Vehicle {
    String Id;
    VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType) {
        Id = id;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return Id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
