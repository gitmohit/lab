package lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.entities;

import lab.mohit.practiceProblem.stockBrokeragePlatform.services.userService.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {
    private String id;
    private String emailId;
    private String phone;
    private String password;
    private AccountStatus accountStatus;
    private static int ID_COUNTER;

    public Account(String emailId, String phone, String password) {
        this.id = "AccountId-" + ID_COUNTER++;
        this.emailId = emailId;
        this.phone = phone;
        this.password = password;
        this.accountStatus = AccountStatus.ACTIVE;
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Account)) {
            return false;
        }
        Account thatAccount = (Account) that;
        return thatAccount.getEmailId().equals(this.getEmailId());
    }

    @Override
    public int hashCode() {
        return this.getEmailId().hashCode();
    }
}
