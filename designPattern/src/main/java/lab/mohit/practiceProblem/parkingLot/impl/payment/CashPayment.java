package lab.mohit.practiceProblem.parkingLot.impl.payment;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.iface.IPayment;

public class CashPayment implements IPayment {
    @Override
    public PaymentStatus makePayment(double parkingFee) {
        System.out.println("Rs " + parkingFee + " Payment Successful by Cash");
        return PaymentStatus.SUCCESS;
    }
}
