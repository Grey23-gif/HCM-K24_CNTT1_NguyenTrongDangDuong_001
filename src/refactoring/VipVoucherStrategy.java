package refactoring;

import java.math.BigDecimal;

public class VipVoucherStrategy implements VoucherStrategy {

    @Override
    public boolean supports(String voucherCode) {
        return voucherCode != null && voucherCode.startsWith("VIP");
    }

    @Override
    public BigDecimal apply(BigDecimal total, String voucherCode) {
        return total.multiply(BigDecimal.valueOf(0.8));
    }
}