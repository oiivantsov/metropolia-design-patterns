package abstract_factory.ascii.view;

// This is a concrete product class.
public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[[ ButtonB ]]\n| " + text + " |\n[[       ]]\n");
    }
}
