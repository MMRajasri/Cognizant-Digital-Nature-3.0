public class FinancialForecast {
    // Recursive method to predict future value
    public double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast();
        
        // Example data
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int years = 10; // Predict for 10 years

        double futureValue = forecast.predictFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value: " + futureValue);
    }
}
