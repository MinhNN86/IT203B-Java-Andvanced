package Session03.LyThuyet.OptionalExample;

import java.util.Optional;

public class OptionalExample03 {
    public static void main(String[] args) {
        Optional<String> me = Optional.of("javacoder");
        Optional<String> emptyOptional = Optional.empty();

        //Filter or Optional
        System.out.println(me.filter(g -> g.equals("JAVACODER")));
        System.out.println(me.filter(g -> g.equalsIgnoreCase("JavaCoder")));
        System.out.println(emptyOptional.filter(g -> g.equalsIgnoreCase("JavaCoder")));
    }
}
