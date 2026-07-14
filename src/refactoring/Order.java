package refactoring;

import java.math.BigDecimal;

public class Order {
    private User user;
    private BigDecimal total;
    private String status;

    public Order(User user, BigDecimal total, String status) {
        this.user = user;
        this.total = total;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }
}