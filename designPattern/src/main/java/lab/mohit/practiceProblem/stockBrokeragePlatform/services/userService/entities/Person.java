package lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Account account;
}