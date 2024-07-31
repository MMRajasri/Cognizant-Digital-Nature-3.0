public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate EmailNotifier with SMSNotifierDecorator
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Further decorate with SlackNotifierDecorator
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification using all decorators
        slackNotifier.send("Hello, this is a test notification!");
    }
}
