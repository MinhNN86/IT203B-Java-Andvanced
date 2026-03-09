package Session02.LyThuyet.InterfaceDefaultMethod;

public class LoginApp {
    public static void main(String[] args) {
        User admin = new Admin();

        admin.login();
        System.out.println("Is admin? " + admin.isAdmin());
        admin.authenticate();

        System.out.println("---");

        User staff = new Staff();
        staff.login();
        System.out.println("Is admin? " + staff.isAdmin());
        staff.authenticate();

    }

}
