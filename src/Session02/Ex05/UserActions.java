package Session02.Ex05;

public interface UserActions {
    default void logActivity(String activity){
        System.out.println("User action: " + activity);
    }
}
