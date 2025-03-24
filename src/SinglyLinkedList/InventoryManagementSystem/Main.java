package SinglyLinkedList.InventoryManagementSystem;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addAtBeginning("Laptop", "101", 5, 700);
        inventory.addAtLast("Mouse", "102", 10, 20);
        inventory.addAtSpecificPosition("Keyboard", "103", 7, 40, 1);

        System.out.println("Current Inventory:");
        inventory.displayInventory();

        System.out.println("Total Inventory Value: $" + inventory.calculateTotalValue());

        inventory.updateQuantity("102", 15);
        System.out.println("After updating quantity:");
        inventory.displayInventory();

        inventory.removeItem("103");
        System.out.println("After removing an item:");
        inventory.displayInventory();
    }
}
