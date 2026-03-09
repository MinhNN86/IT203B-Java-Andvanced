package Session02.Ex03;

public interface Authenticatable {
    // Phương thức trừu tượng
    String getPassword();

    default boolean isAuthenticated() {
        String password = getPassword();
        return password != null && !password.isEmpty();
    }

    static String encrypt(String rawPassword){
        return "ENC_" + rawPassword;
    }
}
