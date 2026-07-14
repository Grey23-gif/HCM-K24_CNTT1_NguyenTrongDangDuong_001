package refactoring;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VoucherResolver voucherResolver = new VoucherResolver(List.of(
                new VipVoucherStrategy(),
                new FreeShipVoucherStrategy()
        ));

        PaymentResolver paymentResolver = new PaymentResolver(List.of(
                new MomoPaymentStrategy(),
                new VnPayPaymentStrategy()
        ));

        NotificationSender notificationSender = new EmailNotificationSender();

        OrderService orderService = new OrderService(
                voucherResolver,
                paymentResolver,
                notificationSender
        );

        Cart cart = new Cart(List.of(
                new Item("Keyboard", BigDecimal.valueOf(500000), 1),
                new Item("Mouse", BigDecimal.valueOf(200000), 2)
        ));

        User user = new User("customer@gmail.com", 1);

        Order order = orderService.checkout(cart, user, "MOMO", "VIP2026");

        System.out.println("Order status: " + order.getStatus());
        System.out.println("Final total: " + order.getTotal());
    }
}