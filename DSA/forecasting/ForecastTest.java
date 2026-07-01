package DSA.forecasting;

public class ForecastTest {
    public static void main(String[] args) {
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int years = 5;

        double futureValue = Forecast.predictFutureValue(currentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
