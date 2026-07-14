package refactoring;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private int quantity;

    public Item(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
