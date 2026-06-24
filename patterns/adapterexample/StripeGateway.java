package adapterexample;

public class StripeGateway {
    public void pay(double cash) {
        System.out.println("Payment of $" + cash + " processed via Stripe.");
    }
}
