package th.co.scb.payment.controller;


import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nonnull;

import org.apache.flink.statefun.flink.harness.Harness;
import org.apache.flink.statefun.flink.harness.io.SerializableSupplier;
import org.apache.flink.util.StringUtils;
import org.junit.Test;
import th.co.scb.payment.debitor.DebitorIO;
import th.co.scb.payment.generated.PaymentOrderRequest;

public class PaymentControllerTest {

    @Test
    public void run() throws Exception {
        Harness harness =
                new Harness()

                        //.withSupplyingIngress(PaymentControllerIO.PAYMENT_ORDER_INGRESS_ID, new MessageGenerator())
                        //.withPrintingEgress(PaymentControllerIO.PAYMENT_ORDER_EGRESS_ID);
                        //.withPrintingEgress(DebitorIO.DEBITOR_EGRESS_ID)
                        ;

        harness.start();
    }

    /** generate a random message, once a second a second. */
    private static final class MessageGenerator
            implements SerializableSupplier<PaymentOrderRequest> {

        private static final long serialVersionUID = 1;

        @Override
        public PaymentOrderRequest get() {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
            return randomMessage();
        }

        @Nonnull
        private PaymentOrderRequest randomMessage() {
            final ThreadLocalRandom random = ThreadLocalRandom.current();
            final String trxId = StringUtils.generateRandomAlphanumericString(random, 10);
            final double amount = randomDouble();

            PaymentOrderRequest.StandardPaymentInstruction debitInstruction = PaymentOrderRequest.StandardPaymentInstruction.newBuilder()
                    .setPaymentType("DEBIT_CASA")
                    .setAmount(amount)
                    .setAccountNumber(randomAccountNumber())
                    .build();

            PaymentOrderRequest.StandardPaymentInstruction creditInstruction = PaymentOrderRequest.StandardPaymentInstruction.newBuilder()
                    .setPaymentType("CREDIT_CASA")
                    .setAmount(amount)
                    .setAccountNumber(randomAccountNumber())
                    .build();

            PaymentOrderRequest orderRequest = PaymentOrderRequest.newBuilder()
                    .setPaymentIdentifier(trxId)
                    .setDebitInstruction(debitInstruction)
                    .setCreditInstruction(creditInstruction)
                    .build();
            return orderRequest;
        }

        private String randomString(){
            final ThreadLocalRandom random = ThreadLocalRandom.current();
            final String randomString = StringUtils.generateRandomAlphanumericString(random, 10);
            return randomString;
        }
        private double randomDouble(){
            final ThreadLocalRandom random = ThreadLocalRandom.current();
            return random.nextDouble(999.99);
        }
        private String randomAccountNumber(){
            final ThreadLocalRandom random = ThreadLocalRandom.current();
            return String.format("%10d", random.nextLong(0000000000L,9999999999L));
        }

    }
}
