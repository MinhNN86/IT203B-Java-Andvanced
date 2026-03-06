package Session01.LyThuyet;

public class Main {
    public static double getAreaTriangle(double a, double b, double c){
        // Kiểm tra a,b,c có tạo thành tam giác hay không
        if(a <= 0 || b <= 0 || c <= 0){
            throw new TriangleException("3 cạnh phải lớn hơn 0");
        }
        if(a + b <= c || a + c <= b || b + c <= a){
            throw new TriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        }
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static int divide (int a, int b){
        return a/b;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Diện tích tam giác: " + getAreaTriangle(3, 0, 5));
        } catch (TriangleException e) {
            System.err.println(e.getMessage());
        }

        try {
            int rs = divide(3, 0);
            System.out.println(rs);
            System.out.println("Tiếp tục thực hiện chương trình");
        } catch (ArithmeticException e){
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Thực hiện các thao tác sau khi try catch");
        }

        System.out.println("Kết thúc chương trình");
    }
}
