package lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.ifaces;

import lab.mohit.practiceProblem.stockBrokeragePlatform.entities.Stock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities.Watchlist;

import java.util.List;

public interface IWatchListManagerService {
    List<Watchlist> getWatchlist(User user);
    Watchlist createWatchlist(Watchlist watchlist);
    Watchlist updateWatchlist(Watchlist watchlist);
    void deleteWatchlist(Watchlist watchlist);
    void addWatchlistItem(Watchlist watchlist, Stock stock);
    void removeWatchlistItem(Watchlist watchlist, Stock stock);
}
