public class ECommerceApp {
    
    public static void main(){
        IShippingService cheese = new  Cheese("Mozzarila Cheese", 100, 400, new Date(125, 9, 10)); // 2025 / 10 / 10
        IShippingService excheese = new  Cheese("Mozzarila Cheese", 100, 400, new Date(125, 5, 10)); // 2025 / 06 / 10
        IShippingService biscuit = new  Biscuit("Biscuit", 10.5, 100, new Date(126, 8, 10)); // 2026 / 09 / 10
        Product mobileScratchCard = new MobileScratchCard("Card", 20, 1000);

        Cart cart = new Cart();
        Customer cust = new Customer(1, "bakr", cart);

        cust.getCart().addProductToCart(cheese , 10);
        cust.getCart().addProductToCart(biscuit , 10);
        cust.getCart().addProductToCart(mobileScratchCard , 100);
        cust.getCart().addProductToCart(mobileScratchCard , 2);

        cust.getCart().checkout();
    }
}