import java.util.Date;

public class ExpireProduct extends Product {
    private Date expiryDate ;


    public ExpireProduct(String name , double price, int quantity ,Date expiryDate) {
        super(name , price , quantity);
        this.expiryDate = expiryDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


}
