package abstract_factory.ascii.view;

// This is a concrete product class.
public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ CheckboxA: " + text + " ]");
    }
}
