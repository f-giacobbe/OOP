package Lezione20;

import oop.geom.v5.AbstractPoint2D;
import java.util.Objects;
import static java.lang.Math.atan2;
import static java.lang.Math.sqrt;

public class CartesianPoint2D extends AbstractPoint2D implements Cloneable {

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




    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }


    /*inseriamo un costruttore per copia
    public CartesianPoint2D(CartesianPoint2D cp) {
        this.x = cp.getX();
        this.y = cp.getY();
    }

    @Override
    public Object clone() {
        return new CartesianPoint2D(this);
    }*/
}
