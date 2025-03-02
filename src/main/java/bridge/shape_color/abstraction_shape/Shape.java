package bridge.shape_color.abstraction_shape;

import bridge.shape_color.implementation_color.Color;

public abstract class Shape {
    protected Color color;

    //standard constructors
    public Shape(Color color) {
        this.color = color;
    }

    abstract public String draw();
}
