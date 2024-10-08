public class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Private constructor to restrict instantiation
    }

    // Public static method to provide access to the instance
    public static synchronized Logger getInstance() {
        // Create a new instance if one doesn't exist
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
