package lab.mohit.practiceProblem.parkingLot.iface;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;

public interface IPayment {
    PaymentStatus makePayment(double parkingFee);
}
