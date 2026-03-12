package Session05.KtraDauGio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());

        if (exists) {
            throw new InvalidProductException("ID sản phẩm đã tồn tại");
        }

        products.add(product);
        System.out.println("Sản phẩm đã được thêm");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào");
            return;
        }

        System.out.println("Danh sách sản phẩm:");
        for (Product p : products) {
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Category: " + p.getCategory());
            System.out.println("-----------------------");
        }
    }

    public void updateProduct(int id, int newQuantity) throws InvalidProductException {
        Optional<Product> product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (product.isPresent()) {
            product.get().setQuantity(newQuantity);
            System.out.println("Sản phẩm đã được cập nhật");
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm với ID: " + id);
        }
    }

    public void deleteProduct() throws InvalidProductException {
        products.removeIf(p -> p.getQuantity() == 0);
        System.out.println("Đã xóa các sản phẩm đã hết hàng");
    }
}
