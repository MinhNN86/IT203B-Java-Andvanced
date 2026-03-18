package Session08.Ex06.payment;

public class CODPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng (COD): " + amount);
    }
}
