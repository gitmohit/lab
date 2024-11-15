package lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.ifaces;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.entities.Order;

public interface IOrderManagementService {
    void placeOrder(Order order);
    void modifyOrder(Order order);
    void cancelOrder(Order order);
}
