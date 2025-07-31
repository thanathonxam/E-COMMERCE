package Lib;

public class CartItem {

    private final Product product;
    private int quantity;

    private void checkRep() {
    if (product == null) {
        throw new RuntimeException("RI violared: product");
    }
    if (quantity <= 0) {
        throw new RuntimeException("RI violared: quantity");
    }
        }
    public CartItem(Product product, int quantity){
    this.product = product ;
    this.quantity = quantity ;
    checkRep();
    }

    public Product getProduct() {return product;}
    public int getQuantity() {return quantity;}


public void increaseQuantity(int amount){
    if (amount > 0) {
        this.quantity += amount;
    }
    checkRep();
    }
}