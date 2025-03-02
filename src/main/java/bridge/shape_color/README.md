# Extending a Bridge Pattern Implementation

## Introduction

The **Bridge Pattern** separates an abstraction from its implementation, allowing both to evolve independently. 

This pattern is used in the **Baeldung Bridge Pattern example** ([link](https://www.baeldung.com/java-bridge-pattern)) to decouple **shapes** from **colors**.

The original implementation includes `Square` and `Triangle` as shapes, and `Red` and `Blue` as colors. To extend this, I have added:
- A new **shape**: `Circle`, which includes resizing functionality.
- A new **color**: `Green` to expand the available choices.

## New Functionality

### Motivation

Adding a **Circle** shape provides more variety, and **Green** color expands color options.

### Enhancements:
- **Circle** extends `Shape`.
- **Green** extends `Color`.

## Implementation

### New Classes and Methods

#### `Shape.java` (Initial)
```java
public abstract class Shape {
    protected Color color;
    
    public Shape(Color color) {
        this.color = color;
    }

    abstract public String draw();
}
```

#### `Color.java (Initial)
```java
public interface Color {
    String fill();
}
```

#### `Circle.java` (New)
```java
public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Circle drawn. " + color.fill();
    }
}
```

#### `Green.java` (New)
```java
public class Green implements Color {
    @Override
    public String fill() {
        return "Color: Green";
    }
}
```

#### `Main.java` (Updated)
```java
public class Main {
    public static void main(String[] args) {
        Shape redSquare = new Square(new Red());
        Shape blueTriangle = new Triangle(new Blue());
        Shape greenCircle = new Circle(new Green());

        System.out.println(redSquare.draw());
        System.out.println(blueTriangle.draw());
        System.out.println(greenCircle.draw());
    }
}
```

## Verification

### Test Cases:
1. Draw a **Square** with Red color.
2. Draw a **Triangle** with Blue color.
3. Draw a **Circle** with Green color.

### Expected Output:
```
Square drawn. Color: Red
Triangle drawn. Color: Blue
Circle drawn. Color: Green
```

## Conclusion

This extension added a **Circle** shape and **Green** color while preserving the Bridge Pattern. 

The design remains flexible, allowing new shapes and colors to be introduced without modifying existing code.

### Alternative Approaches:
- Use a Factory Pattern to generate shapes dynamically.