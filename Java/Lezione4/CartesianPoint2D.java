package Lezione4;

import oop.geom.v3.Point2D;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class CartesianPoint2D implements Lezione4.Point2D {

    private double x;
    private double y;

    public CartesianPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public CartesianPoint2D(){}

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

    /*@Override - sempre implicito
    public double distance(Point2D p) {
        double dx=getX()-p.getX();
        double dy=getY()-p.getY();
        return sqrt(dx*dx+dy*dy);
    } lo posso eliminare

     OVERRIDING - ho comunque la libertà di creare il metodo distance() all'interno
     della classe e con l'@Override sarà eseguito questo invece di quello di default
     dell'interfaccia (del supertipo in questo caso)*/
}
