public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the third-party gateways
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the third-party gateways
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Use the adapters to process payments
        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
    }
}
