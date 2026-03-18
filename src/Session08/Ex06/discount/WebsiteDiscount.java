package Session08.Ex06.discount;

public class WebsiteDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double amount) {
        double discount = amount * 0.10;
        System.out.println("Áp dụng giảm giá 10%: " + discount);
        return amount - discount;
    }
}
