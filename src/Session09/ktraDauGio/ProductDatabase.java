package Session09.ktraDauGio;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase(){
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void add(Product p){
        products.add(p);
    }

    public void delete(String id){
        products.removeIf(p -> p.equals(id));
    }

    public void update(String id, String newName) {
        for (Product p : products) {
            if (p.id.equals(id)) {
                p.name = newName;
            }
        }
    }

    public List<Product> getAll() {
        return products;
    }
}
