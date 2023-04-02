package pl.javastart.task;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Product> products = FileUtils.readProductPriceAndCurrency("src/main/resources/products.csv");
            List<Currency> currencies = FileUtils.readCurrency("src/main/resources/currencies.csv");
            List<BigDecimal> priceInEuro = CalcPriceInEuro.priceInEuro(products, currencies);
            BigDecimal sumPriceInEuro = CalcPriceInEuro.sumPriceInEuro(priceInEuro);
            BigDecimal minPrice = CalcPriceInEuro.getMinPrice(priceInEuro);
            BigDecimal maxPrice = CalcPriceInEuro.getMaxPrice(priceInEuro);
            System.out.println("Suma wszsystkich produktow w €: " + sumPriceInEuro);
            System.out.println("Srednia cena produktu: " + sumPriceInEuro.divide(BigDecimal.valueOf(products.size()), RoundingMode.HALF_UP));
            System.out.println("Najwyższa cena: " + maxPrice);
            System.out.println("Najniższa cena: " + minPrice);
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }
    }
}