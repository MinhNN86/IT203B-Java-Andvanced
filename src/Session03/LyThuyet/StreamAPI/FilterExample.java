package Session03.LyThuyet.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        // Without Stream API
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result1 = new ArrayList<>();
        for(Integer n : numbers1){
            if(n % 2 == 0){
                result1.add(n);
            }
        }
        System.out.println(result1);

        // With Stream API
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result2 = numbers2.stream()
                                        .filter(n -> n % 2 == 0)
                                        .toList();
        System.out.println(result2);
    }
}
