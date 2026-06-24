package strategypattern;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card strategy
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        context.executePayment(250.0);

        // Switch to PayPal strategy
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(500.0);
    }
}
