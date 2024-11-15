package lab.mohit.practiceProblem.parkingLot.impl.payment;

import lab.mohit.practiceProblem.parkingLot.enums.PaymentStatus;
import lab.mohit.practiceProblem.parkingLot.enums.PaymentType;
import lab.mohit.practiceProblem.parkingLot.iface.IParkingFeeCalculator;
import lab.mohit.practiceProblem.parkingLot.iface.IPayment;
import lab.mohit.practiceProblem.parkingLot.iface.IPaymentFactory;
import lab.mohit.practiceProblem.parkingLot.impl.ParkingTicket;

public class PaymentController {
    IPaymentFactory paymentFactory;
    IParkingFeeCalculator parkingFeeCalculator;

    public PaymentController(IPaymentFactory paymentFactory, IParkingFeeCalculator parkingFeeCalculator) {
        this.paymentFactory = paymentFactory;
        this.parkingFeeCalculator = parkingFeeCalculator;
    }

    public PaymentStatus makePayment(ParkingTicket parkingTicket, PaymentType paymentType) {
        IPayment payment = paymentFactory.createPayment(paymentType);
        double parkingFee = parkingFeeCalculator.calculateParkingFee(parkingTicket);
        return payment.makePayment(parkingFee);
    }
}
