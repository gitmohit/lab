package lab.mohit.practiceProblem.parkingLot.iface;

public interface IDisplayObservable {
    void registerDisplay(IDisplay display);
    void removeDisplay(IDisplay display);
    void notifyDisplay();
}
