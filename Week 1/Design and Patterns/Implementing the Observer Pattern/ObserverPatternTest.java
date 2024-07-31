public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Updating stock price to $100.00");
        stockMarket.setStockPrice(100.00);

        System.out.println("Updating stock price to $120.00");
        stockMarket.setStockPrice(120.00);
    }
}
