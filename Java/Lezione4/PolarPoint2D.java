package Lezione4;

import Lezione4.Point2D;

import static java.lang.Math.*;


public class PolarPoint2D implements Lezione4.Point2D {
  private double mod;
  private double ph;

    public PolarPoint2D(double mod, double ph) {
        this.mod = mod;
        this.ph = ph;
    }

    public PolarPoint2D(){}

    /////////
    @Override
    public double distance(Point2D p) {
        System.out.println("distance dentro PolarPoint2D");
        double dx=getX()-p.getX();
        double dy=getY()-p.getY();
        return sqrt(dx*dx+dy*dy);
    }

    @Override
    public double getX() {
        return mod*cos(ph);
    }

    @Override
    public double getY() {
        return mod*sin(ph);
    }

    @Override
    public double getMod() {
        return mod;
    }

    @Override
    public double getPhase() {
        return ph;
    }



}
