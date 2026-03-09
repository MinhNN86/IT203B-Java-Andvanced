package Session02.LyThuyet.Funtional_Interface;

public class CalculatorApp {
    public static void main(String[] args) {
        Caculator rect = new RectangleCalculator();
        int rectPerimeter = rect.calculatePerimeter(10, 5);
        System.out.println(rectPerimeter);

        Caculator rectangle = (a, b) -> 2 * (a + b);
        int perimeter = rectangle.calculatePerimeter(10, 5);
        System.out.println(perimeter);
    }
}
