package lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.entities.Stock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.enums.WatchListStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Watchlist {
    private static int ID_COUNTER = 1;
    private String id;
    private String name;
    private User user;
    private WatchListStatus watchListStatus;
    private List<Stock> stocks;

    public Watchlist(String name, User user) {
        this.id = "Watchlist-" + ID_COUNTER++;
        this.name = name;
        this.user = user;
        this.stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }
}
