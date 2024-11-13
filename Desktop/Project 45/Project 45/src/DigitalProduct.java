public class DigitalProduct extends Product {
    private final String downloadLink;

    public DigitalProduct(int productId, String productName, double price, int quantity, String downloadLink) {
        super(productId, productName, price, quantity);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }
}
