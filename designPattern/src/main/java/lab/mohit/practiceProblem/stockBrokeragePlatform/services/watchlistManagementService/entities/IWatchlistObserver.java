package lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.entities.Stock;

public interface IWatchlistObserver {
    void update(Stock stock);
}
