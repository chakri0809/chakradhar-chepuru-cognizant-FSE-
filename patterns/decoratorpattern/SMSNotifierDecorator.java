package decoratorpattern;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // send via base notifier
        System.out.println("Sending SMS: " + message);
    }
}
