package lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.impls;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.Account;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;
import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.ifaces.IUserManagementService;

import java.util.HashMap;
import java.util.Map;

public class UserManagementService implements IUserManagementService {
    private Map<Account, User> userRegistry;
    private static UserManagementService USER_MANAGEMENT_SERVICE_INSTANCE;

    private UserManagementService() {
        userRegistry = new HashMap<>();
    }

    public static UserManagementService getInstance() {
        if (USER_MANAGEMENT_SERVICE_INSTANCE != null) {
            return USER_MANAGEMENT_SERVICE_INSTANCE;
        }
        synchronized (UserManagementService.class) {
            if (USER_MANAGEMENT_SERVICE_INSTANCE == null) {
                return USER_MANAGEMENT_SERVICE_INSTANCE = new UserManagementService();
            }
            return USER_MANAGEMENT_SERVICE_INSTANCE;
        }
    }

    @Override
    public boolean registerUser(User user) {
        if (userRegistry.containsKey(user.getAccount())) {
            System.out.println("The email exists " + user.getAccount().getEmailId());
            return false;
        }
        System.out.println("Created Account with email " + user.getAccount().getEmailId());
        return true;
    }

    @Override
    public boolean login(User user) {
       return userRegistry.containsKey(user.getAccount()) && user.getAccount().getPassword().equals(userRegistry.get(user.getAccount()).getAccount().getPassword());
    }

    @Override
    public boolean logout(User user) {
        // TODO
        System.out.println("Logged out User");
        return true;
    }

    @Override
    public boolean update(User user) {
        // TODO
        System.out.println("Updated User");
        return true;
    }

}
