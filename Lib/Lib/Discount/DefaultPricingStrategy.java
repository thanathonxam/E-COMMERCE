package Lib.Discount;
import Lib.*;

public class DefaultPricingStrategy implements DiscountStrategy{

    @Override
    public double calculatePrice(CartItem item) {
        return item.getProduct().getprice() * item.getQuantity();
    }
    
}
