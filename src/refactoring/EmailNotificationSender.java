package refactoring;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(User user, Order order) {
        System.out.println("Sending email to " + user.getEmail()
                + " about order total: " + order.getTotal());
    }
}