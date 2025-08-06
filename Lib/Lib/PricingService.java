package Lib;

import java.util.ArrayList;

import Lib.Discount.DefaultPricingStrategy;
import Lib.Discount.DiscountStrategy;

public class PricingService {
    private record StrategyRule(String sku,DiscountStrategy strategy) {}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaulStrategy = new DefaultPricingStrategy();

    public void addStrategy(String sku,DiscountStrategy strategy){
        StrategyRule ruleToRemove = null;
        for(StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) {
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
    }

    public double calculateItemPrice(CartItem item){
        String sku = item.getProduct().getProductId();
        for (StrategyRule rule : strategies){
            if (rule.sku().equals(sku)) {
                return rule.strategy().calculatePrice(item);
            }
        }
        return defaulStrategy.calculatePrice(item);
    }
}