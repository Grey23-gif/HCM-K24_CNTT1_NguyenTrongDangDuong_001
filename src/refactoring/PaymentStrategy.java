package refactoring;

import java.math.BigDecimal;

public interface PaymentStrategy {
    boolean supports(String paymentMethod);

    void pay(BigDecimal amount);
}