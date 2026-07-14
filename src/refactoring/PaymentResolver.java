package refactoring;

import java.util.List;

public class PaymentResolver {
    private final List<PaymentStrategy> strategies;

    public PaymentResolver(List<PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy resolve(String paymentMethod) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(paymentMethod))
                .findFirst()
                .orElseThrow(() -> new PaymentNotSupportedException(paymentMethod));
    }
}