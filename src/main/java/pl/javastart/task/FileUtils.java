package pl.javastart.task;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    static List<Product> readProductPriceAndCurrency(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<Product> products = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] results = line.split(";");
            Product nextProductPrice = new Product(new BigDecimal(results[1]), results[2]);
            products.add(nextProductPrice);
        }
        bufferedReader.close();
        return products;
    }

    static List<Currency> readCurrency(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<Currency> currencies = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] results = line.split(";");
            currencies.add(new Currency(results[0], new BigDecimal(results[1])));
        }
        bufferedReader.close();
        return currencies;
    }
}