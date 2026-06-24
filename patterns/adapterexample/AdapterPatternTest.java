package adapterexample;

public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.0);
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.0);
    }
}
