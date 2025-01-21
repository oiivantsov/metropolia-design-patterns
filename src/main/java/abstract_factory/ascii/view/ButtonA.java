package abstract_factory.ascii.view;

// This is a concrete product class.
public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ ButtonA: " + text + " ]");
    }
}
