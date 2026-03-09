package Session02.LyThuyet.InterfaceDefaultMethod;

public class Admin implements User, AdminAuth {
    @Override
    public void login() {
        System.out.println("Admin logged in");
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    @Override
    public void authenticate() {
        AdminAuth.super.authenticate(); // Gọi phương thức authenticate từ AdminAuth
    }

}
