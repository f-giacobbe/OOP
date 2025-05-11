package Esercitazione2.geom;

import static java.lang.Math.sqrt;

public class CartesianPoint3D implements Point3D {
    private double x;
    private double y;
    private double z;

    public CartesianPoint3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianPoint3D() {}

    public CartesianPoint3D(Point3D p) {
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double distance(Point3D p) {
        double dx = x - p.getX();
        double dy = y - p.getY();
        double dz = z - p.getZ();

        return sqrt(dx * dx + dy * dy + dz * dz);
    }
}
