public class BuilderPatternTest {
    public static void main(String[] args) {
        // Create a high-end computer configuration using the Builder pattern
        Computer highEndComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA GeForce RTX 3080")
                .setMotherboard("ASUS ROG")
                .build();

        // Create a budget computer configuration using the Builder pattern
        Computer budgetComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("Integrated Graphics")
                .build();

        // Print the details of both computers
        System.out.println("High-End Computer: " + highEndComputer);
        System.out.println("Budget Computer: " + budgetComputer);
    }
}
