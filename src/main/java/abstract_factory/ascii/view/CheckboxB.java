package abstract_factory.ascii.view;

// This is a concrete product class.
public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[[ CheckboxB ]]\n[ ] " + text + "\n");
    }
}
