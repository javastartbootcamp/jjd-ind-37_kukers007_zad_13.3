package pl.javastart.task;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;
    private String currency;

    public Product(BigDecimal price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}

