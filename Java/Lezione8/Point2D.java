package Lezione8;

import static java.lang.Math.*;
public interface Point2D {
    double getX();
    double getY();
    double getMod();
    double getPhase();
    default double distance(Point2D p){
        double dx=getX()-p.getX();
        double dy=getY()-p.getY();
        return sqrt(dx*dx+dy*dy);
    }


}
