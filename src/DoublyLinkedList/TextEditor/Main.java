package DoublyLinkedList.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! This is a text editor.");

        editor.displayCurrentState(); // Should display the latest text
        editor.undo();
        editor.displayCurrentState(); // Should display the previous state
        editor.redo();
        editor.displayCurrentState(); // Should go back to the latest state
    }
}
