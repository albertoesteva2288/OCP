package ch.diso.ex05_Generics_Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductCounter {

    private Map<String, Long> productCountMap = new HashMap<>();
    private Map<String, String> productNames = new TreeMap<>();

    public static void main(String[] args) {

        // Lagerbestand
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01",
                "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01",
                "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};

        // Produktkatalog
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug   ", "1M02");

        ProductCounter pc1 = new ProductCounter(productNames);
        pc1.processList(parts);
        pc1.printReport();
    }

    private ProductCounter(Map<String, String> productNames) {
        this.productNames = productNames;
    }

    private void processList(String[] list) {
        long curVal = 0;
        for (String itemNumber : list) {
            if (productCountMap.containsKey(itemNumber)) {
                curVal = productCountMap.get(itemNumber);
                curVal++;
                productCountMap.put(itemNumber, curVal);
            } else {
                productCountMap.put(itemNumber, 1L);
            }
        }
    }

    private void printReport() {
        System.out.println("=== Produkt Report ===");
        for (String key : productNames.keySet()) {
            System.out.print("Name: " + key);
            System.out.println("\t\tAnzahl: " + productCountMap.get(productNames.get(key)));
        }
    }
}