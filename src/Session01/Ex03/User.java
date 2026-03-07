package Session01.Ex03;

public class User {
    private int age;

    public void setAge(int age) throws IllegalAccessException {
        if (age < 0) {
            throw new IllegalAccessException("Tuổi không thể âm!");
        }
        this.age = age;
    }
}
