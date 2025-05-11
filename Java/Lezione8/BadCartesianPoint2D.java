package Lezione8;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class BadCartesianPoint2D extends AbstractPoint2D {
    private double x;
    private double y;

    public BadCartesianPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public BadCartesianPoint2D(BadCartesianPoint2D old) {
        this.x = old.x;
        this.y = old.y;
    }

    public void setX(double v) {
        this.x = v;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getMod() {
        return sqrt(x*x+y*y);
    }

    @Override
    public double getPhase() {
        return atan2(y,x);
    }

}
