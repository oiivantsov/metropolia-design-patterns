package bridge.shape_color.abstraction_shape;

import bridge.shape_color.implementation_color.Color;

public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Triangle drawn. " + color.fill();
    }
}
