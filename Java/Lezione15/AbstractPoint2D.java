package Lezione15;

import oop.geom.v5.Point2D;

public abstract class AbstractPoint2D implements Point2D {


    //fixiamo l'equals in quanto non soddisfa la proprietà transitiva
    /*@Override
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
    }*/
}
