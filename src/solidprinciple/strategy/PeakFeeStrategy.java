package solidprinciple.strategy;

public class PeakFeeStrategy implements FeeStrategy {
	public double calculateFee(double baseFee) {
		return baseFee * 1.5;
	}
}
