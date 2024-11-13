public interface InventoryManageable {
    void addProduct(Product product);
    void updateProductDetails(int productId, String name, double price);
    void updateInventory(int productId, int quantity) throws InvalidStockQuantityException;
    void generateInventoryReport();
}
