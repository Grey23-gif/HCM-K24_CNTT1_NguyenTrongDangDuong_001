package refactoring;

import java.math.BigDecimal;

public class VnPayPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean supports(String paymentMethod) {
        return "VNPAY".equalsIgnoreCase(paymentMethod);
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Connecting to VNPay API. Amount: " + amount);
    }
}