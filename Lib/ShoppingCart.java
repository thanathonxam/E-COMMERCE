package Lib;
import java.util.ArrayList;

public class ShoppingCart {
   
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private PricingService pricingService;
    private ProductCatalog productCatalog;
    // Rep Invariant (RI)
    // ArrayList
    /*
     * ตรวจสอบ Rep Invariant เป็นจริงไหม
     */
    private void checkRep() {
        if (cartItems == null) {
            throw new RuntimeException("RI violared: cartItems cannot be null");
        }
        for (int i = 0; i < cartItems.size(); i++) {
            for(int j = i + 1 ; j < cartItems.size(); j++) {
                if (cartItems.get(i).equals(cartItems.get(j))) {
                    throw new RuntimeException("RI violared: cartItems contains duplicate products");
                }
            }
        }
    }

    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog) {
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
        checkRep();
    }

    public int getItemCount() {
        return cartItems.size();
    }

    public double getTotalPrice() {
        double total = 0 ;
        for(CartItem item : cartItems){
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }

    public void addItem(String productId, int quantity) {
        Product product = productCatalog.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found"+productId);
        }
        for(CartItem item : cartItems){
            if (item.getProduct().getProductId().equals(productId)) {
                item.increaseQuantity(quantity);
                checkRep();
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
        checkRep();
    }

    public void removeItem(String productId) {
        for (int i = 0; i < cartItems.size(); i++) {
        if (cartItems.get(i).getProduct().getProductId().equals(productId)) {
            cartItems.remove(i);
            checkRep();
            return;
        }
    }
    }

    public void clearCart() {
        cartItems.clear();
        checkRep();
    }

}