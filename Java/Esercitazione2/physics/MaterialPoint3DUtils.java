package Esercitazione2.physics;

import Esercitazione2.geom.CartesianPoint3D;
import Esercitazione2.geom.Point3D;

public class MaterialPoint3DUtils {
    public static Point3D getBarycenter(MaterialPoint3D[] a) {
        double totalMass = 0;
        double xcm = 0;
        double ycm = 0;
        double zcm = 0;

        for (MaterialPoint3D p : a) {
            totalMass += p.getMass();
            xcm += p.getPoint().getX() * p.getMass();
            ycm += p.getPoint().getY() * p.getMass();
            zcm += p.getPoint().getZ() * p.getMass();
        }

        xcm = xcm / totalMass;
        ycm = ycm / totalMass;
        zcm = zcm / totalMass;

        return new CartesianPoint3D(xcm, ycm, zcm);
    }
}
