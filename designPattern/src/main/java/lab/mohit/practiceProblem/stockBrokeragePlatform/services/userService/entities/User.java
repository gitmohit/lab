package lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities;

import lombok.Getter;

@Getter
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Account account;
    private static int ID_COUNTER;

    public User(String firstName, String lastName, String address, Account account) {
        this.id = "UserId-" + ID_COUNTER++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.account = account;
    }

}
