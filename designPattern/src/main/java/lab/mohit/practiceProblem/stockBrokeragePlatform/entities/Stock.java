package lab.mohit.practiceProblem.stockBrokeragePlatform.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces.IObservable;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.ifaces.IObserver;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities.IWatchlistObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.annotation.ElementType;
import java.util.List;


@Getter @AllArgsConstructor
public class Stock implements IStockObservable {
    public String id;
    public String name;
    public double price;
    List<IWatchlistObserver> watchlists;

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stock)) {
            return false;
        }
        Stock that = (Stock) o;
        return this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    @Override
    public boolean registerObserver(IWatchlistObserver watchlist) {
       return watchlists.add(watchlist);
    }

    @Override
    public boolean unregisterObserver(IWatchlistObserver watchlist) {
        return watchlists.remove(watchlist);
    }

    @Override
    public boolean notifyObservers() {
        for (IWatchlistObserver watchlist : watchlists) {
            watchlist.update(this);
        }
        return true;
    }
}
