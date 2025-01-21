package abstract_factory.ascii.view;

// This is a concrete product class.
class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[ TextFieldA: " + text + " ]");
    }
}
