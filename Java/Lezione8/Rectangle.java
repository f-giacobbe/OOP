package Lezione8;

public class Rectangle implements Figure2D {
    private final double base;
    private final double height;


    @Override
    public double area() {
        return base*height;
    }

    @Override
    public double perimeter() {
        return 2*base + 2*height;
    }

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
