package abstract_factory.ascii;

import abstract_factory.ascii.view.AFactory;
import abstract_factory.ascii.view.UIFactory;
import abstract_factory.ascii.view.Button;
import abstract_factory.ascii.view.TextField;
import abstract_factory.ascii.view.Checkbox;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create Factory
        UIFactory factory = new AFactory(); // Change to BFactory for style B

        // Create UI Elements
        Button button = factory.createButton("Click Me");
        TextField textField = factory.createTextField("Enter Text");
        Checkbox checkbox = factory.createCheckbox("Check Me");

        // Display Elements
        button.display();
        textField.display();
        checkbox.display();

        // Update Text and Redisplay
        button.setText("New Button Text");
        textField.setText("New TextField Text");
        checkbox.setText("New Checkbox Text");

        button.display();
        textField.display();
        checkbox.display();
    }
}
