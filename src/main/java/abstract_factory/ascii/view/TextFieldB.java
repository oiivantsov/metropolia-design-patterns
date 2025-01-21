package abstract_factory.ascii.view;

// This is a concrete product class.
class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[[ TextFieldB ]]\n| " + text + " |\n[[           ]]\n");
    }
}
