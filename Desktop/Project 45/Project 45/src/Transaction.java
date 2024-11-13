public class Transaction {
    private final int transactionId;
    private final int productId;
    private final int quantity;
    private final double totalAmount;

    public Transaction(int transactionId, int productId, int quantity, double totalAmount) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionId + ", Product ID: " + productId + ", Quantity: " + quantity + ", Total Amount: " + totalAmount);
    }
}
