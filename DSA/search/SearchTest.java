package DSA.search;

import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "Phone", "Electronics"),
            new Product("P103", "Shoes", "Fashion"),
            new Product("P104", "Watch", "Accessories")
        };

        // Linear Search
        int indexLinear = SearchAlgorithms.linearSearch(products, "Shoes");
        System.out.println("Linear Search result: " + (indexLinear != -1 ? products[indexLinear] : "Not Found"));

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Binary Search
        int indexBinary = SearchAlgorithms.binarySearch(products, "Shoes");
        System.out.println("Binary Search result: " + (indexBinary != -1 ? products[indexBinary] : "Not Found"));
    }
}

