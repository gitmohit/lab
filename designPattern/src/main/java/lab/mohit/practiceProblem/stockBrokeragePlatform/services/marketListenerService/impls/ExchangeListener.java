package lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.impls;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.entities.ExchangeStock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces.IObserver;

import java.util.List;

public class ExchangeListener implements IObserver {

    @Override
    public void update(List<ExchangeStock> exchangeStocks) {
        for (ExchangeStock exchangeStock : exchangeStocks) {
             // get stock by id and directly set price
        }
    }
}
