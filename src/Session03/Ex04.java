package Session03;

import java.util.*;
import java.util.stream.Collectors;

public class Ex04 {

    // record User
    record User(String username, String email) {
    }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("minh", "minh@gmail.com"),
                new User("hoa", "hoa@gmail.com"),
                new User("minh", "minh2@gmail.com"),
                new User("tuan", "tuan@gmail.com"),
                new User("hoa", "hoa2@gmail.com"));

        // Loại bỏ trùng username
        List<User> uniqueUsers = users.stream()
                .collect(Collectors.toMap(
                        User::username,
                        user -> user,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .toList();

        // In kết quả
        uniqueUsers.forEach(System.out::println);
    }
}
