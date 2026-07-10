package observerpattern;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp1");
        Observer webApp = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(100.5);
        System.out.println();

        stockMarket.removeObserver(webApp);

        stockMarket.setPrice(105.75);
    }
}
