package pl.javastart.task;

import java.math.BigDecimal;

public class Currency {
    private String currency;
    private BigDecimal exchangeRate;

    public Currency(String currency, BigDecimal exchangeRate) {
        this.currency = currency;
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currency='" + currency + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}

