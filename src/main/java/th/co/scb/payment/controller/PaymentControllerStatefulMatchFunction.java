package th.co.scb.payment.controller;


import org.apache.flink.statefun.sdk.match.MatchBinder;
import org.apache.flink.statefun.sdk.match.StatefulMatchFunction;
import th.co.scb.payment.debitor.DebitorIO;
import th.co.scb.payment.generated.PaymentOrderResponse;
import th.co.scb.payment.generated.PaymentOrderRequest;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.apache.flink.statefun.sdk.annotations.Persisted;
import org.apache.flink.statefun.sdk.state.PersistedValue;


import th.co.scb.payment.debitor.DebitorStatefulFunction;

/**
 * A stateful function that generates a unique greeting for each user based on how many times that
 * user has been seen by the system.
 */
final class PaymentControllerStatefulMatchFunction extends StatefulMatchFunction {

    /**
     * The function type is the unique identifier that identifies this type of function. The type, in
     * conjunction with an identifier, is how routers and other functions can use to reference a
     * particular instance of a greeter function.
     *
     * <p>If this was a multi-module application, the function type could be in different package so
     * functions in other modules could message the greeter without a direct dependency on this class.
     */
    static final FunctionType TYPE = new FunctionType("scb", "payment-ingress");

    /**
     * The persisted value for maintaining state about a particular user. The value returned by this
     * field is always scoped to the current user. seenCount is the number of times the user has been
     * greeted.
     */
    @Persisted
    private final PersistedValue<String> transactionStatus = PersistedValue.of("transaction-status", String.class);

    @Override
    public void configure(MatchBinder matchBinder){
        //matchBinder.predicate(PaymentOrderRequest.class, p->(p.toString().equals("")),this::processDebit);

        //matchBinder.predicate(PaymentOrderRequest.class,  o->{System.out.println();}, this::processDebit)
    }


    public void binvoke(Context context, Object input) {
        PaymentOrderRequest paymentOrder = (PaymentOrderRequest) input;
        System.out.println("------Payment Order------\n" + paymentOrder.toString() + "\n--------------");

        PaymentOrderResponse response = processPayment(paymentOrder);
        context.send(PaymentControllerIO.PAYMENT_ORDER_EGRESS_ID, response);
        PaymentOrderRequest requestDebit = PaymentOrderRequest.newBuilder(paymentOrder)
                .setPaymentOrderStatus("pending-debit")
                .build();
        System.out.println("-------Debit Instruction------\n" + requestDebit.toString()+ "\n--------------");
        context.send(DebitorStatefulFunction.TYPE,response.getOriginalRequest().getPaymentIdentifier(),requestDebit);

    }

    private PaymentOrderResponse processPayment(PaymentOrderRequest paymentOrder) {
        return PaymentOrderResponse.newBuilder()
                .setPaymentResult("pending")
                .setOriginalRequest(paymentOrder)
                .build();
    }
    public PaymentOrderResponse processDebit(PaymentOrderRequest paymentOrder) {
        return PaymentOrderResponse.newBuilder()
                .setPaymentResult("pending")
                .setOriginalRequest(paymentOrder)
                .build();
    }


}
