package lab.mohit.practiceProblem.stockBrokeragePlatform;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.marketListenerService.impls.MockExchange;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.Account;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.ifaces.IUserManagementService;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.impls.UserManagementService;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account("mohit.iiit2k7@gmail.com", "9740104110", "iiit123");
        User user = new User("Mohit", "Kumar", "Address",  account);
        IUserManagementService userManagementService = UserManagementService.getInstance();
        userManagementService.registerUser(user);
        userManagementService.login(user);
        MockExchange mockExchange = new MockExchange();
        mockExchange.mockDrill();

        System.out.println("Hello World");
    }
}
