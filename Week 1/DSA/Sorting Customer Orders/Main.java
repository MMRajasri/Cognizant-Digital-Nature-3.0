public class Main {
    public static void main(String[] args) {
        // Create some orders
        Order[] orders = {
                new Order("O001", "Alice", 250.50),
                new Order("O002", "Bob", 150.75),
                new Order("O003", "Charlie", 300.99),
                new Order("O004", "David", 120.25),
                new Order("O005", "Eve", 450.00)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        BubbleSort.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset orders array to original order
        orders = new Order[]{
                new Order("O001", "Alice", 250.50),
                new Order("O002", "Bob", 150.75),
                new Order("O003", "Charlie", 300.99),
                new Order("O004", "David", 120.25),
                new Order("O005", "Eve", 450.00)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        QuickSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
