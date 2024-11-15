package lab.mohit.designPattern.observer.iface;

public interface IObservable {
    boolean registerObserver(IObserver observer);
    boolean removeObserver(IObserver observer);
    void notifyObserver();
}
