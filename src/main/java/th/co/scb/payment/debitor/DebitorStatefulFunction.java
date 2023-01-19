package th.co.scb.payment.debitor;

import com.google.auto.service.AutoService;
import th.co.scb.payment.controller.PaymentControllerIO;
import th.co.scb.payment.generated.PaymentOrderResponse;
import th.co.scb.payment.generated.PaymentOrderRequest;

import org.apache.flink.statefun.sdk.Context;
import org.apache.flink.statefun.sdk.FunctionType;
import org.apache.flink.statefun.sdk.StatefulFunction;
import org.apache.flink.statefun.sdk.annotations.Persisted;
import org.apache.flink.statefun.sdk.state.PersistedValue;

/**
 * A stateful function that generates a unique greeting for each user based on how many times that
 * user has been seen by the system.
 */
public final class DebitorStatefulFunction implements StatefulFunction {

    /**
     * The function type is the unique identifier that identifies this type of function. The type, in
     * conjunction with an identifier, is how routers and other functions can use to reference a
     * particular instance of a greeter function.
     *
     * <p>If this was a multi-module application, the function type could be in different package so
     * functions in other modules could message the greeter without a direct dependency on this class.
     */
    public static final FunctionType TYPE = new FunctionType("scb", "debitor-ingress");

    /**
     * The persisted value for maintaining state about a particular user. The value returned by this
     * field is always scoped to the current user. seenCount is the number of times the user has been
     * greeted.
     */
    @Persisted
    private final PersistedValue<Integer> seenCount = PersistedValue.of("seen-count", Integer.class);

    @Override
    public void invoke(Context context, Object input) {
        PaymentOrderRequest paymentOrder = (PaymentOrderRequest) input;
        PaymentOrderResponse response = processPayment(paymentOrder);
        context.send(DebitorIO.DEBITOR_EGRESS_ID, response);

    }

    private PaymentOrderResponse processPayment(PaymentOrderRequest paymentOrder) {
        return PaymentOrderResponse.newBuilder()
                .setPaymentResult("debit-success")
                .setOriginalRequest(paymentOrder)
                .build();
    }

}
