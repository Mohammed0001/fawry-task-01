import java.util.Date;

public class CartItem {
    private Product product;
    private int quantity;


    public CartItem(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Insufficient Quantity");
        }

        // Check if the product is expirable and expired
        if (product instanceof ExpireProduct) {
            Date expiryDate = ((ExpireProduct) product).getExpiryDate();
            if (expiryDate.before(new Date())) {
                throw new IllegalArgumentException("Product has expired");
            }
        }

        this.product = product;
        this.quantity = quantity;
        product.decrementQuantity(quantity);
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}