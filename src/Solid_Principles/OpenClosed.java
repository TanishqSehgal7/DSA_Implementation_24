package Solid_Principles;

public class OpenClosed {

	interface DiscountPolicy {
		
		double applyDiscount(double totalAmount);
	}
	
	public static class RegularDiscount implements DiscountPolicy {

		@Override
		public double applyDiscount(double totalAmount) {
			return 0;
		}
		
	}
	
	public static class PremiumDiscount implements DiscountPolicy {

		@Override
		public double applyDiscount(double totalAmount) {
			return totalAmount * 0.1;
		}
		
	}
	
	public static class VipDiscount implements DiscountPolicy {

		@Override
		public double applyDiscount(double totalAmount) {
			return totalAmount * 0.3;
		}
		
	}
	
	public static class FestiveDiscount implements DiscountPolicy {
		
		@Override
		public double applyDiscount(double totalAmount) {
			return totalAmount * 0.4;
		}
		
	}
	
	public static class DiscountCalculator {
		
		public double calculateDiscount(DiscountPolicy discountPolicy, double totalAmount) {
			return discountPolicy.applyDiscount(totalAmount);
		}
		
	}
 	
	public static void main(String[] args) {
		
		DiscountCalculator discountCalculator = new DiscountCalculator();
		
		RegularDiscount regularDiscount = new RegularDiscount();
		System.out.println("Regular Discount: " + regularDiscount.applyDiscount(5000));
		
		PremiumDiscount premiumDiscount = new PremiumDiscount();
		System.out.println("Premium Discount: " + premiumDiscount.applyDiscount(5000));

		VipDiscount vipDiscount = new VipDiscount();
		System.out.println("VIP Discount: " + vipDiscount.applyDiscount(5000));
		
		FestiveDiscount festiveDiscount = new FestiveDiscount();
		System.out.println("Festive Discount: " + festiveDiscount.applyDiscount(5000));	
	}
}
