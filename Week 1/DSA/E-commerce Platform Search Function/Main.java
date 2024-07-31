import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Smartphone", "Electronics"),
                new Product("P003", "Tablet", "Electronics"),
                new Product("P004", "Headphones", "Accessories"),
                new Product("P005", "Charger", "Accessories")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Product result = Search.linearSearch(products, "Tablet");
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        // Sort products array by productName for Binary Search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        // Binary Search
        System.out.println("\nBinary Search:");
        result = Search.binarySearch(products, "Tablet");
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }
    }
}
