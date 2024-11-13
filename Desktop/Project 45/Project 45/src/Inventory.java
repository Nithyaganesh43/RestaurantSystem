
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inventory {
    public void updateInventory(int productId, int quantity) throws SQLException, InvalidStockQuantityException, ProductNotFoundException {
        if (quantity < 0) {
            throw new InvalidStockQuantityException("Quantity cannot be negative.");
        }
        String query = "UPDATE Product SET quantity = ? WHERE productId = ?";
        try (Connection conn = DatabaseHelper.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, productId);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new ProductNotFoundException("Product not found with ID: " + productId);
            }
            System.out.println("Inventory updated.");
        }
    }
}
