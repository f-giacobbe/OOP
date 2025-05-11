package Lezione15;

import oop.geom.v5.AbstractPoint2D;

import java.util.Objects;

import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class CartesianPoint2D extends AbstractPoint2D {

    private final double x;
    private final double y;

    public CartesianPoint2D(double x, double y) {

        this.x = x;
        this.y = y;
    }
    public CartesianPoint2D(){
        this.x=0.0;
        this.y=0.0;
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





    @Override
    public String toString(){
        return "<x="+getX()+",y="+getY()+">";
    }


    //lezione15
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != CartesianPoint2D.class) {
            return false;
        }

        CartesianPoint2D other = (CartesianPoint2D) obj;

        return x==other.x && y==other.y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);  //hash automatico a partire da due valori double
    }
}
