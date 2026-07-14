package refactoring;

import java.math.BigDecimal;

public class MomoPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean supports(String paymentMethod) {
        return "MOMO".equalsIgnoreCase(paymentMethod);
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Connecting to Momo API. Amount: " + amount);
    }
}