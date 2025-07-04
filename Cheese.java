import java.util.Date;

public class Cheese extends ExpireProduct implements IShippingService {

    public Cheese(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity, expiryDate);
        
    }

    @Override
    public double getWeight() {
       return super.weight;
    }

    @Override
    public void setWeight(double weight) {
        super.weight = weight;
    }
    
}
