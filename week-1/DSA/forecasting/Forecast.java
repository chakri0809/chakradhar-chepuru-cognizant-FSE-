package DSA.forecasting;


public class Forecast {

    // Formula: futureValue = currentValue * (1 + growthRate) ^ years
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue; // base case
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }
}

