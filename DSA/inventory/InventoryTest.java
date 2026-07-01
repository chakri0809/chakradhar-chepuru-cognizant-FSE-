package DSA.inventory;

public class InventoryTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product("P101", "Laptop", 10, 75000);
        Product p2 = new Product("P102", "Phone", 20, 25000);

        manager.addProduct(p1);
        manager.addProduct(p2);

        manager.displayInventory();

        manager.updateProduct("P101", 8, 72000);

        manager.deleteProduct("P102");

        manager.displayInventory();
    }
}

