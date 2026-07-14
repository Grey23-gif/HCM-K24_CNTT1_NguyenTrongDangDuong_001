package refactoring;

import java.math.BigDecimal;

public class FreeShipVoucherStrategy implements VoucherStrategy {

    private static final BigDecimal SHIPPING_DISCOUNT = BigDecimal.valueOf(30000);

    @Override
    public boolean supports(String voucherCode) {
        return voucherCode != null && voucherCode.startsWith("FREESHIP");
    }

    @Override
    public BigDecimal apply(BigDecimal total, String voucherCode) {
        BigDecimal result = total.subtract(SHIPPING_DISCOUNT);
        return result.max(BigDecimal.ZERO);
    }
}