package Session09.ktraDauGio;

public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Digital - " + id + " - " + name +
                " - " + price + " - size: " + size);
    }
}
