package solidprinciple;

interface FeeStrategy{
	public double calculateFee(double baseFee);
}
class NormalFeeStrategy implements FeeStrategy {
    public double calculateFee(double baseFee) {
        return baseFee;
    }
}
class RainyFeeStrategy  implements FeeStrategy {
    public double calculateFee(double baseFee) {
        return baseFee*1.2;
    }
}
class PeakFeeStrategy  implements FeeStrategy {
    public double calculateFee(double baseFee) {
        return baseFee*1.5;
    }
}
class FestivalFeeStrategy   implements FeeStrategy {
    public double calculateFee(double baseFee) {
        return baseFee*1.8;
    }
}
 class DeliveryFeeCalculator {
	private FeeStrategy strategy;
	
	public DeliveryFeeCalculator(FeeStrategy feeStrategy) {
		this.strategy=feeStrategy;
	}
	
	public void setFeeStrategy(FeeStrategy feeStrategy) {
		this.strategy=feeStrategy;
	}
	public double getFee(double baseFee) {
        return strategy.calculateFee(baseFee);
    }
}

public class SwiggyAppStrategy {
 public static void main(String[] args) {
	 DeliveryFeeCalculator dfc=new DeliveryFeeCalculator(new FestivalFeeStrategy());
	 System.out.println(dfc.getFee(40));
	 
	 DeliveryFeeCalculator dfc1=new DeliveryFeeCalculator(new NormalFeeStrategy());
	 System.out.println(dfc1.getFee(40));
	 
	 DeliveryFeeCalculator dfc12=new DeliveryFeeCalculator(new PeakFeeStrategy());
	 System.out.println(dfc12.getFee(40));
}
}
