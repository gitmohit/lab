package lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.entities.ExchangeStock;

import java.util.List;

public interface IObserver {
    void update(List<ExchangeStock> exchangeStocks);
}
