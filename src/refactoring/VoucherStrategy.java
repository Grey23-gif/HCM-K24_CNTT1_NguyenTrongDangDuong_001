package refactoring;

import java.math.BigDecimal;

public interface VoucherStrategy {
    boolean supports(String voucherCode);

    BigDecimal apply(BigDecimal total, String voucherCode);
}