package bridge.shape_color.abstraction_shape;

import bridge.shape_color.implementation_color.Color;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
