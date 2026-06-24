package decoratorpattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        slackNotifier.send("System maintenance scheduled at 10 PM.");
    }
}
