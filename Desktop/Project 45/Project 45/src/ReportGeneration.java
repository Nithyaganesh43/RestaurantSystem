
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReportGeneration {
    public void generateInventoryReport() throws SQLException {
        String query = "SELECT * FROM Product WHERE quantity < 10";  // For low stock products
        try (Connection conn = DatabaseHelper.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("productId"));
                System.out.println("Product Name: " + rs.getString("productName"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("---------------------------------");
            }
        }
    }
}
