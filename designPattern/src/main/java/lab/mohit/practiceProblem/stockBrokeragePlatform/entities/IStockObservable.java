package lab.mohit.practiceProblem.stockBrokeragePlatform.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities.IWatchlistObserver;

public interface IStockObservable {
    boolean registerObserver(IWatchlistObserver observer);
    boolean unregisterObserver(IWatchlistObserver observer);
    boolean notifyObservers();
}
