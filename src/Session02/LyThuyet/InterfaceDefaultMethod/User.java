package Session02.LyThuyet.InterfaceDefaultMethod;

interface User {
    void login();

    default boolean isAdmin() {
        return false;
    }

    default void authenticate() {
        System.out.println("User authenticated");
    }
}
