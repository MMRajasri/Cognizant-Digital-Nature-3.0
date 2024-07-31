public class SingletonTest {
    public static void main(String[] args) {
        // Retrieve the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("logger1 and logger2 refer to different instances.");
        }

        // Use the Logger instance to log messages
        logger1.log("This is a test log message.");
        logger2.log("Logging from another reference.");
    }
}
