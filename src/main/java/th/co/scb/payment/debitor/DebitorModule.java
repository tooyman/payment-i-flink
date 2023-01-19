package th.co.scb.payment.debitor;

import com.google.auto.service.AutoService;
import java.util.Map;
import org.apache.flink.statefun.sdk.spi.StatefulFunctionModule;
import th.co.scb.payment.controller.PaymentControllerIO;
import th.co.scb.payment.debitor.DebitorRouter;
import th.co.scb.payment.debitor.DebitorStatefulFunction;

/**
 * The top level entry point for this application.
 *
 * <p>On deployment, the address of the Kafka brokers can be configured by passing the flag
 * `--kafka-address &lt;address&gt;`. If no flag is passed, then the default address will be used.
 */
@AutoService(StatefulFunctionModule.class)
public final class DebitorModule implements StatefulFunctionModule {

    private static final String KAFKA_KEY = "kafka-address";

    private static final String DEFAULT_KAFKA_ADDRESS = "localhost:9092";

    @Override
    public void configure(Map<String, String> globalConfiguration, Binder binder) {

        // pull the configured kafka broker address, or default if none was passed.
        String kafkaAddress = globalConfiguration.getOrDefault(KAFKA_KEY, DEFAULT_KAFKA_ADDRESS);
        DebitorIO ioModule = new DebitorIO(kafkaAddress);

        // bind an ingress to the system along with the router
        binder.bindIngress(ioModule.getIngressSpec());
        binder.bindIngressRouter(DebitorIO.DEBITOR_INGRESS_ID, new DebitorRouter());

        // bind an egress to the system
        binder.bindEgress(ioModule.getEgressSpec());


        binder.bindFunctionProvider(DebitorStatefulFunction.TYPE, unused -> new DebitorStatefulFunction());
        //binder.bindEgress(ByeIO);

        //binder.bindIngressRouter(PaymentControllerIO.PAYMENT_ORDER_INGRESS_ID, new PaymentControllerRouter());

    }
}
