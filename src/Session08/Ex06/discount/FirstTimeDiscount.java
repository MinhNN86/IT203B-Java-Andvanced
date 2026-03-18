package Session08.Ex06.discount;

public class FirstTimeDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount) {
        double discount = 0.15; // 15% discount for first-time customers
        System.out.println("Áp dụng giảm giá 15% (lần đầu): " + discount);
        return amount - discount;
    }
}
