package bridge.shape_color.abstraction_shape;

import bridge.shape_color.implementation_color.Color;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Circle drawn. " + color.fill();
    }
}
