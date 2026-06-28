package solidprinciple.strategy;

//Tomorrow — add FESTIVAL — ZERO existing class touched!
public class FestivalFeeStrategy implements FeeStrategy {
 public double calculateFee(double baseFee) {
     return baseFee * 1.8;
 }
}
