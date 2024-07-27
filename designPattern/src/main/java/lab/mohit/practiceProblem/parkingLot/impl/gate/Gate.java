package lab.mohit.practiceProblem.parkingLot.impl.gate;

import lab.mohit.practiceProblem.parkingLot.iface.IGate;
import lab.mohit.practiceProblem.parkingLot.impl.users.ParkingAssistant;

public class Gate implements IGate {
    String Id;
    ParkingAssistant parkingAssistant;

    public Gate(String id, ParkingAssistant assistant) {
        Id = id;
        this.parkingAssistant = assistant;
    }

    @Override
    public void open() {
        System.out.println("Opened");
    }

    @Override
    public void close() {
        System.out.println("Closed");
    }

    @Override
    public void setParkingAssistant(ParkingAssistant parkingAssistant) {
        this.parkingAssistant = parkingAssistant;
    }

}
