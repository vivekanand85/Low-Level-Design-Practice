package solidprinciple.strategy;

public class NormalFeeStrategy implements FeeStrategy {
	@Override
	public double calculateFee(double baseFee) {
		return baseFee;
	}

}
