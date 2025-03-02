package bridge.shape_color;

import bridge.shape_color.abstraction_shape.Shape;
import bridge.shape_color.abstraction_shape.Square;
import bridge.shape_color.abstraction_shape.Triangle;
import bridge.shape_color.abstraction_shape.Circle;
import bridge.shape_color.implementation_color.Blue;
import bridge.shape_color.implementation_color.Green;
import bridge.shape_color.implementation_color.Red;

// initial code source: https://www.baeldung.com/java-bridge-pattern
public class Main {
    public static void main(String[] args) {
        Shape redSquare = new Square(new Red());
        Shape blueTriangle = new Triangle(new Blue());

        System.out.println(redSquare.draw());
        System.out.println(blueTriangle.draw());

        // extension with additional functionality
        Shape greenCircle = new Circle(new Green());
        System.out.println(greenCircle.draw());
    }
}
