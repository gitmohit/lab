package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.impl.users.ParkingAssistant;

public interface IGate {
    void open();

    void close();

    void setParkingAssistant(ParkingAssistant parkingAssistant);
}
