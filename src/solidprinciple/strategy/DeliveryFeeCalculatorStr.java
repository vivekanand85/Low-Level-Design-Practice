package solidprinciple.strategy;

public class DeliveryFeeCalculatorStr {
	private FeeStrategy strategy;
	public DeliveryFeeCalculatorStr(FeeStrategy feeStrategy) {
		this.strategy=feeStrategy;
	}
	 public void setStrategy(FeeStrategy strategy) {
	        this.strategy = strategy;
	 }
	 public double getFee(double baseFee) {
		 return strategy.calculateFee(baseFee);
	 }
}
