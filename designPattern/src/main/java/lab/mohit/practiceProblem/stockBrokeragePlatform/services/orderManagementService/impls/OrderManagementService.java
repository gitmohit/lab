package lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.impls;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.entities.Order;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.enums.OrderStatus;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.ifaces.IOrderManagementService;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;

import java.util.HashMap;
import java.util.Map;

public class OrderManagementService implements IOrderManagementService {
    private Map<User, Map<String, Order>> orderBook;
    public static OrderManagementService ORDER_MANAGEMENT_SERVICE_INSTANCE;

    private OrderManagementService() {
        orderBook = new HashMap<>();
    }

    public static OrderManagementService getOrderManagementServiceInstance() {
        if (ORDER_MANAGEMENT_SERVICE_INSTANCE != null) {
            return ORDER_MANAGEMENT_SERVICE_INSTANCE;
        }
        synchronized (OrderManagementService.class) {
            if (ORDER_MANAGEMENT_SERVICE_INSTANCE != null) {
                return ORDER_MANAGEMENT_SERVICE_INSTANCE;
            }
            return ORDER_MANAGEMENT_SERVICE_INSTANCE = new OrderManagementService();
        }
    }

    @Override
    public void placeOrder(Order order) {
        User user = order.getUser();
        orderBook.computeIfAbsent(user, k -> new HashMap<>()).put(order.getId(), order);
    }

    @Override
    public void modifyOrder(Order order) { // assuming that it is an existing order
        User user = order.getUser();
        orderBook.get(user).put(order.getId(), order);
    }

    @Override
    public void cancelOrder(Order order) { // assuming that it is an existing order
        User user = order.getUser();
        orderBook.get(user).get(order.getId()).setOrderStatus(OrderStatus.CANCELLED);
    }
}
