package Esercitazione2.physics;

import Esercitazione2.geom.CartesianPoint3D;
import Esercitazione2.geom.Point3D;

public class MaterialPoint3D {
    private Point3D point;
    private double mass;

    public MaterialPoint3D(double x, double y, double z, double mass) {
        if (mass < 0) {
            System.exit(-1);
        }

        this.point = new CartesianPoint3D(x, y, z);
        this.mass = mass;
    }

    public MaterialPoint3D(Point3D point, double mass) {
        this.point = new CartesianPoint3D(point);
        this.mass = mass;
    }

    public Point3D getPoint() {
        return this.point;
    }

    public double getMass() {
        return this.mass;
    }
}
