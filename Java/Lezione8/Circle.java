package Lezione8;

public class Circle implements Figure2D {
    private final double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new NegativeRadiusException("radius must be a positive number");
        }

        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2.0 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
