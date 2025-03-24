package DoublyLinkedList.TextEditor;

public class Node {
    String text;
    Node prev, next;

    Node(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}
