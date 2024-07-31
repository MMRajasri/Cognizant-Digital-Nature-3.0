public class StrategyPatternTest {
    public static void main(String[] args) {
        // Using Credit Card Payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(150.00);

        // Using PayPal Payment
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext = new PaymentContext(payPalPayment);
        paymentContext.executePayment(200.00);
    }
}
