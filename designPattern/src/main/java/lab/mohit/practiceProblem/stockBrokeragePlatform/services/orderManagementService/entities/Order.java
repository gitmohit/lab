package lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.entities.Stock;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.orderManagementService.enums.OrderStatus;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private String id;
    private Stock stock;
    private int quantity;
    private double pricePosition;
    private User user;
    private OrderStatus orderStatus;
    public static int ID_COUNTER = 1;
    public Order(Stock stock, int quantity, User user, double pricePosition) {
        this.id = "Order-" + ID_COUNTER++;
        this.stock = stock;
        this.quantity = quantity;
        this.pricePosition = pricePosition;
        this.user = user;
        this.orderStatus = OrderStatus.OPEN;
    }
}
