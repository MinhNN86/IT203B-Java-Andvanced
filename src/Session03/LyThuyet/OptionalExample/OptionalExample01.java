package Session03.LyThuyet.OptionalExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample01 {
    public static void main(String[] args) {
        // Pre Java 8
        List<String> list = getList();
        List<String> listOpt = list != null ? list : new ArrayList<>();
        System.out.println(listOpt);

        // Java 8
        List<String> listOpt2 = getList2().orElse(new ArrayList<>());
        List<String> listOpt3 = getList2().orElseGet(ArrayList::new);
        System.out.println(listOpt2);
        System.out.println(listOpt3);
    }

    private static List<String> getList(){
        return null;
    }

    private static Optional<List<String>> getList2(){
        return Optional.ofNullable(null);
    }
}
