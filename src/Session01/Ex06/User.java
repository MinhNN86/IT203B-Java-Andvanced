package Session01.Ex06;

public class User {
    private String name;
    private int age;

    public void setName(String name) {
        if(name != null){
            this.name = name;
        } else {
            System.out.println("Tên không được null!");
        }
    }

    public void setAge(int age) throws InvalidAgeException{
        if(age < 0){
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public void printUser(){
        if(name != null){
            System.out.println("Tên người dùng: " + name);
        }
    }
}
