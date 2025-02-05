package memento.simpleTextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setText("hello!");
        history.save(editor);

        editor.setText("changed text!");
        history.save(editor);

        System.out.println("Current text: " + editor.getText()); // changed text!

        history.undo(editor);
        System.out.println("After Undo: " + editor.getText()); // Hello!

        history.undo(editor);
        System.out.println("After 2nd Undo: " + editor.getText()); // ""
    }
}