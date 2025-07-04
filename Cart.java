import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;
    private double total;
    private double totalWeight;
    private double subTotal;
    private double shippingFees;

    public Cart() {
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.subTotal = 0.0;
        this.shippingFees = 50.0;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public void addProductToCart(Product product, int quantity) {
        try {
            CartItem c = new CartItem(product, quantity);
            items.add(c);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void calculateSubTotal() {
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i).getProduct();
            subTotal = subTotal + (product.getPrice() * items.get(i).getQuantity());
        }
    }

    public void calculateTotal() {
        total = subTotal + shippingFees;
    }

    public void calculateTotalWeight() {
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i).getProduct();
            if (product instanceof IShippingService) {
                IShippingService shippable = (IShippingService) product;
                totalWeight = totalWeight + (shippable.getWeight() * items.get(i).getQuantity());
            }
        }
    }

    public void printShipment() {
        System.out.println("** Shipment notice **");
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i).getProduct();
            if (product instanceof IShippingService) {
                IShippingService shippable = (IShippingService) product;
                System.out.println(
                        items.get(i).getQuantity() + "X " + shippable.getName() + "\t" + shippable.getWeight());
            }
        }
        calculateTotalWeight();
        System.out.println("Total package weight " + totalWeight);
        System.out.println("\n\n");
    }

    public void printCheckout() {
        System.out.println("** Checkout receipt **");
        System.out.println("----------------------");
        for (int i = 0; i < items.size(); i++) {
            Product product = items.get(i).getProduct();
            System.out.println(items.get(i).getQuantity() + "X " + product.getName() + "\t" + product.getPrice());
        }
        calculateSubTotal();
        System.out.println("Subtotal " + subTotal);
        System.out.println("Shipping " + shippingFees);
        calculateTotal();
        System.out.println("Amount " + total);
        System.out.println("\n\n");
    }

    public void checkout() {
        printShipment();
        printCheckout();
    }

}
