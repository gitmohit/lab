package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentType;

public interface IPaymentFactory {
    IPayment createPayment(PaymentType paymentType);
}
