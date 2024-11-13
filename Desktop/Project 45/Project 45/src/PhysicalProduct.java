public class PhysicalProduct extends Product {
    private final String size;

    public PhysicalProduct(int productId, String productName, double price, int quantity, String size) {
        super(productId, productName, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
