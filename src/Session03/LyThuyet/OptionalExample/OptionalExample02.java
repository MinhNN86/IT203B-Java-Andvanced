package Session03.LyThuyet.OptionalExample;

import java.util.Optional;

public class OptionalExample02 {
    public static void main(String[] args) {
        Optional<String> optinalOf = Optional.of("Welcome To JavaCoder");
        Optional<String> optinalEmpty = Optional.empty();

        System.out.println(optinalOf.map(String::toLowerCase));
        System.out.println(optinalEmpty.map(String::toLowerCase));

        Optional<Optional<String>> multipleOptional = Optional.of(Optional.of("javacoder"));

        System.out.println("Value of Optional object: " + multipleOptional);
        System.out.println("Optinal.map: " + multipleOptional.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optinal.flatMap: " + multipleOptional.flatMap(gender -> gender.map(String::toUpperCase)));
    }
}
