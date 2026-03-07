package Session01;

import java.io.IOException;

public class Ex04 {

    // Method C
    public static void saveToFile() throws IOException{
        // Giả lập lỗi khi ghi file
        throw new IOException("Lỗi khi lưu dữ liệu vào file!");
    }

    // Method B
    public static void processUserData() throws IOException{
        // gọi method C và đẩy lỗi lên trên
        saveToFile();
    }

    // Method A
    public static void main(String[] args) {
        try {
            processUserData();
        } catch (IOException e){
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
