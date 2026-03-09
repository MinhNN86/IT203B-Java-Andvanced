package Session02.LyThuyet.InterfaceDefaultMethod;

interface AdminAuth {
    default void authenticate() {
        System.out.println("Admin authenticated");
    }
}
