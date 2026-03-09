package Session02.LyThuyet.Method_references;

import java.util.List;
import java.util.function.*;

public class StudentApp {

    // Phương thức tĩnh để minh họa 4.1
    public static void printUpperCase(String s) {
        System.out.println(s.toUpperCase());
    }

    public static void main(String[] args) {

        // ============================================================
        // 4.1. Tham chiếu phương thức Static (Class::staticMethod)
        // Dùng khi Lambda nhận tham số và truyền thẳng vào hàm static
        // ============================================================
        System.out.println("=== 4.1. Static Method Reference ===");

        // Lambda
        Function<String, Integer> toIntLambda = s -> Integer.parseInt(s);
        // Method Reference
        Function<String, Integer> toInt = Integer::parseInt;

        System.out.println("Lambda:           " + toIntLambda.apply("123"));
        System.out.println("Method Reference: " + toInt.apply("123"));

        // Thêm ví dụ: dùng với danh sách
        List<String> names = List.of("alice", "bob", "charlie");
        System.out.println("-- In tên viết hoa (static method reference) --");
        names.forEach(StudentApp::printUpperCase); // Class::staticMethod

        // ============================================================
        // 4.2. Tham chiếu phương thức Instance của đối tượng CỤ THỂ
        // (object::instanceMethod)
        // ============================================================
        System.out.println("\n=== 4.2. Instance Method Reference (specific object) ===");

        // Lambda
        Consumer<String> printerLambda = s -> System.out.println(s);
        // Method Reference (System.out là đối tượng cụ thể)
        Consumer<String> printer = System.out::println;

        System.out.print("Lambda:           ");
        printerLambda.accept("Hello Lambda!");
        System.out.print("Method Reference: ");
        printer.accept("Hello Method Reference!");

        // Thêm ví dụ: StringBuilder cụ thể
        StringBuilder sb = new StringBuilder("Xin chào");
        Supplier<String> getContent = sb::toString; // sb là đối tượng cụ thể
        System.out.println("Nội dung StringBuilder: " + getContent.get());

        // ============================================================
        // 4.3. Tham chiếu phương thức Instance của đối tượng BẤT KỲ
        // thuộc một kiểu cụ thể (Class::instanceMethod)
        // → Tham số đầu tiên của Lambda chính là đối tượng gọi method
        // ============================================================
        System.out.println("\n=== 4.3. Instance Method Reference (arbitrary object) ===");

        // Lambda
        BiPredicate<String, String> checkerLambda = (s1, s2) -> s1.equals(s2);
        // Method Reference
        BiPredicate<String, String> checker = String::equals;

        System.out.println("Lambda:           " + checkerLambda.test("Java", "Java"));
        System.out.println("Method Reference: " + checker.test("Java", "Java"));
        System.out.println("Khác nhau:        " + checker.test("Java", "Python"));

        // Thêm ví dụ: chuyển String thành chữ hoa
        Function<String, String> toUpper = String::toUpperCase; // s -> s.toUpperCase()
        System.out.println("toUpperCase: " + toUpper.apply("hello world"));

        // Sắp xếp danh sách theo alphabet
        List<String> animals = List.of("Zebra", "Cat", "Ant", "Dog");
        animals.stream()
                .sorted(String::compareToIgnoreCase) // (s1, s2) -> s1.compareToIgnoreCase(s2)
                .forEach(System.out::println);

        // ============================================================
        // 4.4. Tham chiếu Constructor (Class::new)
        // Sử dụng để tạo mới một đối tượng
        // ============================================================
        System.out.println("\n=== 4.4. Constructor Reference ===");

        // Lambda
        Supplier<StringBuilder> sbSupplierLambda = () -> new StringBuilder();
        // Method Reference
        Supplier<StringBuilder> sbSupplier = StringBuilder::new;

        StringBuilder sb1 = sbSupplierLambda.get();
        StringBuilder sb2 = sbSupplier.get();
        sb1.append("Tạo bằng Lambda");
        sb2.append("Tạo bằng Constructor Reference");
        System.out.println("Lambda:           " + sb1);
        System.out.println("Method Reference: " + sb2);

        // Thêm ví dụ: Function nhận tham số, tạo StringBuilder với nội dung ban đầu
        Function<String, StringBuilder> sbWithContent = StringBuilder::new; // s -> new StringBuilder(s)
        System.out.println("StringBuilder từ String: " + sbWithContent.apply("Hello!"));
    }
}
