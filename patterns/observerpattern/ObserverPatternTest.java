package observerpattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price
        stockMarket.setPrice(100.5);
        System.out.println();

        // Remove one observer
        stockMarket.removeObserver(webApp);

        // Change stock price again
        stockMarket.setPrice(105.75);
    }
}
