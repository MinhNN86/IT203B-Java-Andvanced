package Session03;

import java.util.*;

public class Ex05 {

    // record User
    record User(String username, String email) {
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alex", "alex@gmail.com"),
                new User("alexander", "alexander@gmail.com"),
                new User("charlotte", "charlotte@gmail.com"),
                new User("ben", "ben@gmail.com"),
                new User("Benjamin", "benjamin@gmail.com"),
                new User("anna", "anna@gmail.com"));

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.username()));
    }
}
