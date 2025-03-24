package DoublyLinkedList.TextEditor;

public class TextEditor {
    private Node current;
    private int historyLimit = 10;
    private int historySize = 0;

    public void addTextState(String newText) {
        Node newNode = new Node(newText);
        if (current != null) {
            newNode.prev = current;
            current.next = newNode;
        }
        current = newNode;
        historySize++;

        // Ensure history limit
        if (historySize > historyLimit) {
            Node temp = current;
            while (temp.prev != null && historySize > historyLimit) {
                temp = temp.prev;
                historySize--;
            }
            temp.prev = null;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }
}
