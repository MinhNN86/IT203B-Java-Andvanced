package Session03;

import java.util.List;
import java.util.Optional;

public class Ex03 {
    public record User(String username, String email, String status) {
    }

    static class UserRepository {
        private List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"));

        public Optional<User> findUserByUsername(String username) {
            return users.stream()
                    .filter(user -> user.username().equals(username))
                    .findFirst();
        }
    }

    public static void main(String[] args) {
        UserRepository repo = new UserRepository();

        Optional<User> userOpt = repo.findUserByUsername("bob");

        userOpt.ifPresentOrElse(user -> System.out.println("Welcome " + user.username()),
                () -> System.out.println("Guest login"));
    }
}
