package Lib.Discount;
import Lib.*;

public class BogoDiscountStrategy implements DiscountStrategy{

    @Override
    public double calculatePrice(CartItem item) {
        int quantity = item.getQuantity();
        double price = item.getProduct().getprice();
        int quantityToPay = (quantity / 2) + (quantity % 2);
        return price * quantityToPay;
    }
    
    
}
