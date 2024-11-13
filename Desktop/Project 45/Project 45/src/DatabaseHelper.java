import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_system";
    private static final String USER = "root";
    private static final String PASSWORD = "Nithyaganesh@123";

    public static Connection getConnection() throws SQLException {
        Connection con =  DriverManager.getConnection(URL, USER, PASSWORD);
        if (con != null) {
            System.out.println("Connection to the database was successful!");
        }
        return con;
    }

    public static void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (productId, productName, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.executeUpdate();
        }
    }

    public static void viewAllProducts() throws SQLException {
        String query = "SELECT * FROM Product";
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
 
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int supplierId = rs.getInt("supplierId");
 
                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Supplier ID: " + supplierId);
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }
    }
}
