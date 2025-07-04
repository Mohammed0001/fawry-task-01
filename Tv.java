
public class Tv extends Product implements IShippingService {
    
    public Tv(String name, double price, int quantity){
        super(name, price, quantity);
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
