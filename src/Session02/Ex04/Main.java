package Session02.Ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice"));
        users.add(new User("bob"));
        users.add(new User("charlie"));

        // (user) -> user.getUsername()
        Function<User, String> getUsername = User::getUsername;

        // (s) -> System.out.println(s)
        Consumer<String> print = System.out::println;

        // () -> new User()
        Supplier<User> createUser = User::new;

        // sử dụng
        users.stream()
                .map(getUsername)
                .forEach(print);

        User newUser = createUser.get();
        System.out.println(newUser.getUsername());
    }
}
