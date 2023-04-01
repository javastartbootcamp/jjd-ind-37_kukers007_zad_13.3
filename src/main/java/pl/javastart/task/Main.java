package pl.javastart.task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    @SuppressWarnings("checkstyle:LocalVariableName")
    public static void main(String[] args) {
        try {
            List<Product> products = FileUtils.readProductPriceAndCurrency("src/main/resources/products.csv");
            List<Currency> currencies = FileUtils.readCurrency("src/main/resources/currencies.csv");
            BigDecimal sumPriceInEuro = getSumPriceInEuro(products, currencies);
            System.out.println("Suma wszsystkich produktow w €: " + sumPriceInEuro);
            System.out.println("Srednia cena produktu: " + sumPriceInEuro.divide(BigDecimal.valueOf(products.size()), RoundingMode.HALF_UP));
            System.out.println("Najniższa cena: " + Collections.max(priceInEuro(products, currencies)));
            System.out.println("Najwyższa cena: " + Collections.min(priceInEuro(products, currencies)));
        } catch (FileNotFoundException e) {
            System.err.println("nie ma pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigDecimal getSumPriceInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal priceInEuro;
        BigDecimal sumPriceInEuro = BigDecimal.ZERO;
        for (Product product : products) {
            for (Currency currency : currencies) {
                if (product.getCurrency().equals(currency.getCurrency())) {
                    priceInEuro = product.getPrice().divide(currency.getExchangeRate(), 40, RoundingMode.HALF_UP);
                    sumPriceInEuro = sumPriceInEuro.add(priceInEuro);
                    break;
                }
            }
        }
        return sumPriceInEuro;
    }

    private static List<BigDecimal> priceInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal priceInEuro = BigDecimal.ZERO;
        List<BigDecimal> listPriceInEuro = new ArrayList<>();
        for (Product product : products) {
            for (Currency currency : currencies) {
                if (product.getCurrency().equals(currency.getCurrency())) {
                    priceInEuro = product.getPrice().divide(currency.getExchangeRate(), 20, RoundingMode.HALF_UP);
                    listPriceInEuro.add(priceInEuro);
                }
            }
        }
        return listPriceInEuro;
    }
}