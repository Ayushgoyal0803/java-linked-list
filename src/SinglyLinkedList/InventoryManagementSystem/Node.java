package SinglyLinkedList.InventoryManagementSystem;

public class Node {
    String itemName;
    String itemId;
    int quantity;
    double price;
    Node next;

    Node(String itemName,String itemId , int quantity, double price){
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        next = null;
    }

}
