package Session02.LyThuyet.Funtional_Interface;

public class RectangleCalculator implements Caculator{
    @Override
    public int calculatePerimeter(int a, int b) {
        return 2 * (a + b);
    }

}
