package solidprinciple.strategy;

public class RainyFeeStrategy implements FeeStrategy {
	@Override
	public double calculateFee(double baseFee) {
		return baseFee * 1.2;
	}

}
