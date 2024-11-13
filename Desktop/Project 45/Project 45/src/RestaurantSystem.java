import java.sql.SQLException;
import java.util.Scanner;

public class RestaurantSystem {
    public static void main(String[] args) throws ProductNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. View Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();   
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(id, name, price, quantity);
                    try {
                        DatabaseHelper.addProduct(product);
                        System.out.println("Product added successfully.");
                    } catch (SQLException e) {
                        System.err.println("Error adding product: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    try {
                        inventory.updateInventory(updateId, newQuantity);
                    } catch (SQLException | InvalidStockQuantityException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        DatabaseHelper.viewAllProducts();
                        System.out.println("-------------------------------------------");
                    } catch (SQLException e) {
                        System.err.println("Error adding product: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            
                    }
    }
}
