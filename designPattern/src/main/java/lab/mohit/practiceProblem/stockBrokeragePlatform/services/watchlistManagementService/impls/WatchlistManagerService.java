package lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.impls;

import lab.mohit.practiceProblem.stockBrokeragePlatform.entities.Stock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.entities.Watchlist;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.enums.WatchListStatus;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.watchlistManagementService.ifaces.IWatchListManagerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WatchlistManagerService implements IWatchListManagerService {
    private Map<User, Map<String, Watchlist>> watchlistRegistry;
    private WatchlistManagerService WATCHLIST_MANAGER_SERVICE_INSTANCE;
    private WatchlistManagerService() {
        watchlistRegistry = new HashMap<>();
    }

    public WatchlistManagerService getWatchlistManagerServiceInstance() {
        if (WATCHLIST_MANAGER_SERVICE_INSTANCE != null) {
            return WATCHLIST_MANAGER_SERVICE_INSTANCE;
        }
        synchronized (WatchlistManagerService.class) {
            if (WATCHLIST_MANAGER_SERVICE_INSTANCE != null) {
                return WATCHLIST_MANAGER_SERVICE_INSTANCE;
            }
            return    WATCHLIST_MANAGER_SERVICE_INSTANCE = new WatchlistManagerService();
        }
    }

    @Override
    public List<Watchlist> getWatchlist(User user) {
        return (List<Watchlist>) watchlistRegistry.get(user).values();
    }

    @Override
    public Watchlist createWatchlist(Watchlist watchlist) {
        return watchlistRegistry.computeIfAbsent(watchlist.getUser(), k-> new HashMap<>()).put(watchlist.getId(), watchlist);
    }

    @Override
    public Watchlist updateWatchlist(Watchlist watchlist) {
        return watchlistRegistry.get(watchlist.getUser()).put(watchlist.getId(), watchlist);
    }

    @Override
    public void deleteWatchlist(Watchlist watchlist) {
        watchlistRegistry.get(watchlist.getUser()).get(watchlist.getId()).setWatchListStatus(WatchListStatus.DELETED);
    }

    @Override
    public void addWatchlistItem(Watchlist watchlist, Stock stock) {
        watchlistRegistry.get(watchlist.getUser()).get(watchlist.getId()).addStock(stock);
    }

    @Override
    public void removeWatchlistItem(Watchlist watchlist, Stock stock) {
        watchlistRegistry.get(watchlist.getUser()).get(watchlist.getId()).removeStock(stock);
    }
}