package hello.servlet.domain.coffee;

public class Coffee {
    private Long coffeeId;
    private String name;
    private Integer price;
    private Integer quantity;

    public Coffee(Long coffeeId, String name, Integer price, Integer quantity) {
        this.coffeeId = coffeeId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void minusCoffeeQuantity(Integer quantity) {
        this.quantity -= quantity;
    }
}