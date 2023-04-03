package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalcPriceInEuro {

    static BigDecimal getMinPrice(List<BigDecimal> result) {
        return Collections.min(result);
    }

    static BigDecimal getMaxPrice(List<BigDecimal> result) {
        return Collections.max(result);
    }

    static BigDecimal sumPriceInEuro(List<BigDecimal> prices) {
        BigDecimal sumPriceInEuro = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            sumPriceInEuro = sumPriceInEuro.add(price);
        }
        return sumPriceInEuro;
    }

    static List<BigDecimal> priceInEuro(List<Product> products, List<Currency> currencies) {
        List<BigDecimal> listPriceInEuro = new ArrayList<>();
        for (Product product : products) {
            Currency productCurrency = findCurrencyByCode(product.getCurrency(), currencies);
            assert productCurrency != null;
            BigDecimal priceInEuro = product.getPrice().divide(productCurrency.getExchangeRate(), 20, RoundingMode.HALF_UP);
            listPriceInEuro.add(priceInEuro);
        }
        return listPriceInEuro;
    }

    private static Currency findCurrencyByCode(String currencyCode, List<Currency> currencies) {
        for (Currency currency : currencies) {
            if (currencyCode.equals(currency.getCurrency())) {
                return currency;
            }
        }
        return null;
    }
}