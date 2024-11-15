package lab.mohit.practiceProblem.parkingLot.impl.payment;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentType;
import lab.mohit.practiceProblem.parkingLot.iface.IPayment;
import lab.mohit.practiceProblem.parkingLot.iface.IPaymentFactory;

public class PaymentFactory implements IPaymentFactory {
    @Override
    public IPayment createPayment(PaymentType paymentType) {
        switch (paymentType) {
            case CASH -> {
                return new CardPayment();
            } case UPI -> {
                return new UPIPayment();
            } case CARD -> {
                return new CardPayment();
            } default -> {
               return null; //TODO: correct it.
            }
        }
    }
}
