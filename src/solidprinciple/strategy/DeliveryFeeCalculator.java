package solidprinciple.strategy;

public class DeliveryFeeCalculator {
    public double calculateFee(double baseFee, String condition) {
        if (condition.equals("NORMAL")) {
            return baseFee;
        } else if (condition.equals("RAINY")) {
            return baseFee * 1.2;
        } else if (condition.equals("PEAK")) {
            return baseFee * 1.5;
        }
        return baseFee;
    }
}
