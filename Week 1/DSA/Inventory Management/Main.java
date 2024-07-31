public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Create some products
        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 20, 499.99);
        Product product3 = new Product("P003", "Tablet", 15, 299.99);

        // Add products to inventory
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // Display all products
        System.out.println("All Products:");
        inventory.displayProducts();

        // Update a product
        Product updatedProduct = new Product("P002", "Smartphone", 25, 479.99);
        inventory.updateProduct("P002", updatedProduct);

        // Display all products after update
        System.out.println("\nAfter Update:");
        inventory.displayProducts();

        // Delete a product
        inventory.deleteProduct("P003");

        // Display all products after deletion
        System.out.println("\nAfter Deletion:");
        inventory.displayProducts();
    }
}
