package th.co.scb.payment.debitor;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import com.google.protobuf.InvalidProtocolBufferException;
import th.co.scb.payment.generated.PaymentOrderRequest;
import th.co.scb.payment.generated.PaymentOrderResponse;



import org.apache.flink.statefun.sdk.io.EgressIdentifier;
import org.apache.flink.statefun.sdk.io.EgressSpec;
import org.apache.flink.statefun.sdk.io.IngressIdentifier;
import org.apache.flink.statefun.sdk.io.IngressSpec;
import org.apache.flink.statefun.sdk.kafka.KafkaEgressBuilder;
import org.apache.flink.statefun.sdk.kafka.KafkaEgressSerializer;
import org.apache.flink.statefun.sdk.kafka.KafkaIngressBuilder;
import org.apache.flink.statefun.sdk.kafka.KafkaIngressDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * A collection of all the components necessary to consume from and write to an external system, in
 * this case Apache Kafka.
 *
 * <p>The ingress and egress identifiers provide named references without exposing the underlying
 * system. This way, in a multi-module deployment, functions can interact with IO modules through
 * identifiers without depending on specific implementations.
 */
public final class DebitorIO {

    public static final IngressIdentifier<PaymentOrderRequest> DEBITOR_INGRESS_ID =
            new IngressIdentifier<>(PaymentOrderRequest.class, "scb", "debitor-ingress");

    public static final EgressIdentifier<PaymentOrderResponse> DEBITOR_EGRESS_ID =
            new EgressIdentifier<>("scb", "kafka-debitor-output", PaymentOrderResponse.class);

    private final String kafkaAddress;

    DebitorIO(String kafkaAddress) {
        this.kafkaAddress = Objects.requireNonNull(kafkaAddress);
    }

    IngressSpec<PaymentOrderRequest> getIngressSpec() {
        return KafkaIngressBuilder.forIdentifier(DEBITOR_INGRESS_ID)
                .withKafkaAddress(kafkaAddress)
                .withTopic("debitor-request")
                .withDeserializer(th.co.scb.payment.debitor.DebitorIO.DebitorKafkaDeserializer.class)
                .withProperty(ConsumerConfig.GROUP_ID_CONFIG, "debitor")
                .build();
    }

    EgressSpec<PaymentOrderResponse> getEgressSpec() {
        return KafkaEgressBuilder.forIdentifier(DEBITOR_EGRESS_ID)
                .withKafkaAddress(kafkaAddress)
                .withSerializer(th.co.scb.payment.debitor.DebitorIO.DebitorKafkaSerializer.class)
                .build();
    }

    private static final class DebitorKafkaDeserializer
            implements KafkaIngressDeserializer<PaymentOrderRequest> {

        private static final long serialVersionUID = 1L;

        @Override
        public PaymentOrderRequest deserialize(ConsumerRecord<byte[], byte[]> input) {
            String who = new String(input.value(), StandardCharsets.UTF_8);
            try {
                //PaymentOrderRequest request = PaymentOrderRequest.newBuilder().mergeFrom(input.value()).build();
                PaymentOrderRequest request = PaymentOrderRequest.parseFrom(input.value());
                return request;
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private static final class DebitorKafkaSerializer implements KafkaEgressSerializer<PaymentOrderResponse> {

        private static final long serialVersionUID = 1L;

        @Override
        public ProducerRecord<byte[], byte[]> serialize(PaymentOrderResponse response) {
            //byte[] key = response.getWho().getBytes(StandardCharsets.UTF_8);
            //byte[] value = response.getGreeting().getBytes(StandardCharsets.UTF_8);
            byte[] key = response.getPaymentResult().getBytes(StandardCharsets.UTF_8);
            byte[] value = response.toByteArray();
            return new ProducerRecord<>("debitor-result", key, value);
        }
    }
}
