package refactoring;

public class PaymentNotSupportedException extends RuntimeException {
    public PaymentNotSupportedException(String paymentMethod) {
        super("Payment method is not supported: " + paymentMethod);
    }
}