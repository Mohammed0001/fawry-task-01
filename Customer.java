
public class Customer {
    private int id;
    private String name;
    private Cart cart;

    public Customer(int id, String name, Cart cart) {
        this.id = id;
        this.name = name;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cartItems) {
        this.cart = cartItems;
    }

    

}
