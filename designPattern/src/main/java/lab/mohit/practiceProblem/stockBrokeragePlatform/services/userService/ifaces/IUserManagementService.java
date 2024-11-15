package lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.ifaces;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities.User;

public interface IUserManagementService {
    boolean registerUser(User user);
    boolean login(User user);
    boolean logout(User user);
    boolean update(User user);
}
