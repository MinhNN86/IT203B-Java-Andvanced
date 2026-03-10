package Session03.LyThuyet.OptionalExample;

import java.util.Optional;

public class OptionalExample04 {
    public static void main(String[] args) {
        Optional<String> shouldNotBeEmpty = Optional.empty();
        shouldNotBeEmpty.orElseThrow(() -> new IllegalArgumentException("This should not happen!!!"));
    }
}
