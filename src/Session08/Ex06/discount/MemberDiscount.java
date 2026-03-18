package Session08.Ex06.discount;

public class MemberDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double amount) {
        double discount = amount * 0.05;
        System.out.println("Áp dụng giảm giá 5% cho thành viên: " + discount);
        return amount - discount;
    }
}
