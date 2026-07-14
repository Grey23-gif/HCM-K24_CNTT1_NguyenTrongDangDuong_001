package refactoring;

import java.util.List;

public class VoucherResolver {
    private final List<VoucherStrategy> strategies;

    public VoucherResolver(List<VoucherStrategy> strategies) {
        this.strategies = strategies;
    }

    public VoucherStrategy resolve(String voucherCode) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(voucherCode))
                .findFirst()
                .orElse(new NoVoucherStrategy());
    }
}