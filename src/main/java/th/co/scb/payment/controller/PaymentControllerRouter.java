package th.co.scb.payment.controller;

import org.apache.flink.statefun.sdk.io.Router;
import th.co.scb.payment.generated.PaymentOrderRequest;

/**
 * The greet router takes each message from an ingress and routes it to a greeter function based on
 * the users id.
 */
final class PaymentControllerRouter implements Router<PaymentOrderRequest> {

    @Override
    public void route(PaymentOrderRequest message, Downstream<PaymentOrderRequest> downstream) {
        downstream.forward(PaymentControllerStatefulFunction.TYPE, message.getPaymentIdentifier (), message);
    }
}
