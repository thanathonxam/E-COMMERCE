import Lib.*;

public class App {
    /**
     * จุดเริ่มต้นการทำงานของโปรแกรมทดสอบ
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("--- Starting Comprehensive E-commerce System Tests ---");
    // --- Setup ---
        Product a = new Product("P001", "Apple", 10.0);
        Product b = new Product("P002", "Soda", 5.0);
        Product c = new Product("P003", "Bread", 20.0);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(a); catalog.addProduct(a);
        catalog.addProduct(b);
        catalog.addProduct(c);

        CartItem item1 = new CartItem(catalog.findById("P001"), 2);
        CartItem item2 = new CartItem(b, 2);
    
    
    }
}