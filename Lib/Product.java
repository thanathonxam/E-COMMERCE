package Lib;
/**
 * 
 */
public final class Product {
    private final String productId;
    private final String productName;
    private final double price;

private void checkRep() {
    if (productId == null || productId.isBlank()) {
        throw new RuntimeException("RI violared: product");
    }
    if (productName == null || productName.isBlank()) {
        throw new RuntimeException("RI violared: product");
    }
    if (price < 0) {
        throw new RuntimeException("RI violared: price");
    }
}
/**
 * 
 */
public Product(String productId, String productName,double price){
    this.productId = productId ;
    this.productName = productName ;
    this.price = price ;
    checkRep();
}

public String getProductId(){return productId;}
public String getProductName(){return productName;}
public double getprice(){return price;}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Product product = (Product) obj;
    return productId.equals(product.productId);
}

}