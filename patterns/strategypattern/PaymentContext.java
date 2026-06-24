package strategypattern;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
