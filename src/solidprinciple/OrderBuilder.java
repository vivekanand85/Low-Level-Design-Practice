package solidprinciple;

//@lombok
public class OrderBuilder {

	  // Required fields
    private final String itemName;
    private final int quantity;
    private final String address;
    private final String paymentType;

    // Optional fields
    private final String couponCode;
    private final boolean isGift;
    private final String giftMessage;
    private final boolean isPriority;
    private OrderBuilder(Builder builder) {
        this.itemName = builder.itemName;
        this.quantity = builder.quantity;
        this.address = builder.address;
        this.paymentType = builder.paymentType;
        this.couponCode = builder.couponCode;
        this.isGift = builder.isGift;
        this.giftMessage = builder.giftMessage;
        this.isPriority = builder.isPriority;
    }
    
    public static class Builder {
        // Required
        private final String itemName;
        private final int quantity;
        private final String address;
        private final String paymentType;

        // Optional — defaults set here
        private String couponCode = null;
        private boolean isGift = false;
        private String giftMessage = null;
        private boolean isPriority = false;

        // Required fields in Builder constructor
        public Builder(String itemName, int quantity,
                      String address, String paymentType) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.address = address;
            this.paymentType = paymentType;
        }
        public Builder couponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public Builder isGift(boolean isGift) {
            this.isGift = isGift;
            return this;
        }

        public Builder giftMessage(String giftMessage) {
            this.giftMessage = giftMessage;
            return this;
        }

        public Builder isPriority(boolean isPriority) {
            this.isPriority = isPriority;
            return this;
        }
        
     // Terminal method — creates Order
        public OrderBuilder build() {
            // Validation before object creation
            if (isGift && giftMessage == null) {
                throw new IllegalStateException(
                    "Gift message required for gift orders!");
            }
            return new OrderBuilder(this);
        }
    } 
    
    public static void main(String[] args) {
    	OrderBuilder order = new OrderBuilder.Builder("Pizza", 2, "Bengaluru", "UPI")
                .couponCode("SWIGGY50")
                .isGift(true)
                .giftMessage("Happy Birthday!")
                .isPriority(true)
                .build();
    	
    	

    	// Minimum order — only required fields
    	OrderBuilder simpleOrder = new OrderBuilder.Builder("Burger", 1, "Bengaluru", "CARD")
    	                        .build();
	}
    
    
}




