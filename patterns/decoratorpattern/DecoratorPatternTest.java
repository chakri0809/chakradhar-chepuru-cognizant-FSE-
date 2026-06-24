package decoratorpattern;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier: Email only
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Add Slack functionality on top of SMS + Email
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification via all channels
        slackNotifier.send("System maintenance scheduled at 10 PM.");
    }
}
