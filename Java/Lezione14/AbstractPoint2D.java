package Lezione14;

import oop.geom.v5.Point2D;

public abstract class AbstractPoint2D implements Point2D {

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return  true;
        if(obj instanceof Point2D p){
            return p.distance(this)<=EPS;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int res = 17;
        double x = getX();
        long lx = Double.doubleToLongBits(x);
        res = res*31 + (int)(lx ^ (lx >>> 32));

        double y = getY();
        long ly = Double.doubleToLongBits(y);
        res = res*31 + (int)(ly ^ (ly >>> 32));

        return res;


        //rimane però il problema dell'EPS
    }
}
