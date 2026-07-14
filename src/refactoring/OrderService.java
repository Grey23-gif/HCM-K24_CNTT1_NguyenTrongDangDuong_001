package refactoring;

import java.math.BigDecimal;

public class OrderService {
    private final VoucherResolver voucherResolver;
    private final PaymentResolver paymentResolver;
    private final NotificationSender notificationSender;

    public OrderService(
            VoucherResolver voucherResolver,
            PaymentResolver paymentResolver,
            NotificationSender notificationSender
    ) {
        this.voucherResolver = voucherResolver;
        this.paymentResolver = paymentResolver;
        this.notificationSender = notificationSender;
    }

    public Order checkout(Cart cart, User user, String paymentMethod, String voucherCode) {
        validateUser(user);

        BigDecimal total = calculateTotal(cart);

        VoucherStrategy voucherStrategy = voucherResolver.resolve(voucherCode);
        BigDecimal finalTotal = voucherStrategy.apply(total, voucherCode);

        PaymentStrategy paymentStrategy = paymentResolver.resolve(paymentMethod);
        paymentStrategy.pay(finalTotal);

        Order order = new Order(user, finalTotal, "SUCCESS");

        notificationSender.send(user, order);

        return order;
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }

        if (user.getStatus() != 1) {
            throw new RuntimeException("User locked");
        }
    }

    private BigDecimal calculateTotal(Cart cart) {
        if (cart == null || cart.getItems() == null) {
            throw new IllegalArgumentException("Cart must not be null");
        }

        return cart.getItems()
                .stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}