package lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces;

public interface IObservable {
    boolean registerObserver(IObserver observer);
    boolean unregisterObserver(IObserver observer);
    boolean notifyObservers();
}
