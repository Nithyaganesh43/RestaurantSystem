public class Supplier {
    private final int supplierId;
    private final String name;
    private final String contactDetails;

    public Supplier(int supplierId, String name, String contactDetails) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }
}
