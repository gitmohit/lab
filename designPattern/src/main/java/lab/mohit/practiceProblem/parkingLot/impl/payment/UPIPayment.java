package lab.mohit.practiceProblem.parkingLot.impl.payment;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.iface.IPayment;

public class UPIPayment implements IPayment {
    @Override
    public PaymentStatus makePayment(double parkingFee) {
        System.out.println("Rs " + parkingFee + " Payment Successful by UPI");
        return PaymentStatus.SUCCESS;
    }
}
