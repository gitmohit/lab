package lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.impls;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.entities.ExchangeStock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces.IObservable;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class MockExchange implements IObservable {
    private List<IObserver> exchangeListeners;
    private List<ExchangeStock> exchangeStocks;

    public MockExchange() {
        exchangeListeners = new ArrayList<>();
        exchangeStocks = new ArrayList<>();
        for (int i=0; i<10; i++) {
            exchangeStocks.add(new ExchangeStock("StockId-"+i, "StockName-"+i, Math.random()));
        }
    }
    @Override
    public boolean registerObserver(IObserver observer) {
        return exchangeListeners.add(observer);
    }

    @Override
    public boolean unregisterObserver(IObserver observer) {
        return exchangeListeners.remove(observer);
    }

    @Override
    public boolean notifyObservers() {
        for(IObserver exchangeListener : exchangeListeners) {
            exchangeListener.update(exchangeStocks);
        }
        return true;
    }

    public void mockDrill() throws InterruptedException {
        while(true) {
            System.out.println("Running mockdrill");
            for (int i=0; i<10; i++) {
                exchangeStocks.forEach(stock -> stock.setPrice(Math.random()));
            }
            valueChanged();
            Thread.sleep(10000);
        }
    }

    private void valueChanged() {
        notifyObservers();
    }
}
