package strategypattern;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876"));
        context.executePayment(250.0);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(500.0);
    }
}
