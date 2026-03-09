package Session02.Ex03;

public class Main {
    public static void main(String[] args) {
        User user = new User("123456");
        System.out.println(user.isAuthenticated());

        String encrypted = Authenticatable.encrypt(user.getPassword());
        System.out.println(encrypted);
    }
}
