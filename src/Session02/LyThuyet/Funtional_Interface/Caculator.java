package Session02.LyThuyet.Funtional_Interface;

@FunctionalInterface
public interface Caculator {
    int calculatePerimeter(int a, int b);

    static int calculateArea(int a){
        return a * a;
    }

    default double getPi(){
        return Math.PI;
    }
}
