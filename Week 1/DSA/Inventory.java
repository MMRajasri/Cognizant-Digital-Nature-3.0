import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update a product
    public void updateProduct(String productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Get a product
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Display all products
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
