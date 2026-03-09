package Session02.LyThuyet.InterfaceDefaultMethod;

public class Staff implements User, AdminAuth {
    @Override
    public void login() {
        System.out.println("Staff logged in");
    }

    @Override
    public void authenticate() {
        User.super.authenticate(); // Gọi phương thức authenticate từ User
    }
}
