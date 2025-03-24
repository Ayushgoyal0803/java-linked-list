package SinglyLinkedList.InventoryManagementSystem;

public class Inventory {
    private Node head;

    public void addAtBeginning(String itemName, String itemId, int quantity, double price){
        Node newNode = new Node(itemName,itemId,quantity,price);
        if(head != null ){
           newNode.next = head;
        }
        head = newNode ;
    }

    public void addAtLast(String itemName, String itemId, int quantity, double price){
        Node newNode = new Node(itemName,itemId,quantity,price);
        if ( head == null ) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void addAtSpecificPosition(String itemName, String itemId, int quantity, double price, int position) {
        Node newNode = new Node(itemName, itemId, quantity, price);

        // Case 1: Adding at the head (position 0)
        if (position == 0) {
            newNode.next = head; // Link new node to current head
            head = newNode; // Update head to new node
            System.out.println("Item added at position " + position + ": " + itemId);
            return;
        }

        // Case 2: Adding at a specific position in the middle or end
        Node curr = head;
        int currentIndex = 0;

        // Traverse to find the position before where we want to insert
        while (curr != null && currentIndex < position - 1) {
            curr = curr.next;
            currentIndex++;
        }

        // If curr is null, it means we've reached the end of the list without finding the position
        if (curr == null) {
            System.out.println("Position " + position + " exceeds list size. Item not added.");
            return; // Optionally, you could append at the end instead.
        }

        // Insert new node at the specified position
        newNode.next = curr.next; // Link new node to next node
        curr.next = newNode; // Link previous node to new node

        System.out.println("Item added at position " + position + ": " + itemId);
    }


    public void removeItem(String itemId) {
        // Check if the list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Check if the item to be removed is the head
        if (head.itemId.equalsIgnoreCase(itemId)) {
            head = head.next; // Remove the head
            System.out.println("Item removed: " + itemId);
            return;
        }

        // Initialize current node to traverse the list
        Node curr = head;

        // Traverse the list to find the item
        while (curr.next != null && !curr.next.itemId.equalsIgnoreCase(itemId)) {
            curr = curr.next;
        }

        // If the item was found, remove it
        if (curr.next != null) {
            curr.next = curr.next.next; // Bypass the node to be removed
            System.out.println("Item removed: " + itemId);
        } else {
            System.out.println("Item not found.");
        }
    }

    public void searchItemByName(String itemName){
        Node currNode=head;
        while(currNode!=null){
            if(currNode.itemName.equalsIgnoreCase(itemName)){
                System.out.println("Item found: " + currNode.itemName + " (ID: " + currNode.itemId + ", Quantity: " + currNode.quantity + ", Price: $" + currNode.price + ")");
            }
            currNode=currNode.next;
        }
        System.out.println("Item name " + itemName + " not found.");

    }

    public void updateQuantity(String itemId, int newQuantity) {
        Node curr = head;
        while (curr != null) {
            if (curr.itemId.equals(itemId)) {
                curr.quantity = newQuantity;
                return;
            }
            curr = curr.next;
        }
    }

    public void searchItemById(String itemId) {
        Node curr = head;
        while (curr != null) {
            if (curr.itemId.equalsIgnoreCase(itemId)) {
                System.out.println("Item found: " + curr.itemName + " (ID: " + curr.itemId + ", Quantity: " + curr.quantity + ", Price: $" + curr.price + ")");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Item not found.");
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        Node curr = head;
        while (curr != null) {
            totalValue += curr.price * curr.quantity;
            curr = curr.next;
        }
        return totalValue;
    }

    public void displayInventory() {
        Node curr = head;
        while (curr != null) {
            System.out.println("Item Name: " + curr.itemName + ", Item ID: " + curr.itemId + ", Quantity: " + curr.quantity + ", Price: $" + curr.price);
            curr = curr.next;
        }
    }


}
