package memento.simpleTextEditor;

public class TextEditor {
    private String text = "";

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // save state
    public Memento save() {
        return new Memento(text);
    }

    // restore state
    public void restore(Memento memento) {
        this.text = memento.getState();
    }
}