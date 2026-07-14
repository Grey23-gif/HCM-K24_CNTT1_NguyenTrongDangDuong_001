package refactoring;

import java.math.BigDecimal;

public class NoVoucherStrategy implements VoucherStrategy {

    @Override
    public boolean supports(String voucherCode) {
        return true;
    }

    @Override
    public BigDecimal apply(BigDecimal total, String voucherCode) {
        return total;
    }
}