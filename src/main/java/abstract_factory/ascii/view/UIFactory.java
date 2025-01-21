package abstract_factory.ascii.view;

// This is the abstract factory class.
public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}
