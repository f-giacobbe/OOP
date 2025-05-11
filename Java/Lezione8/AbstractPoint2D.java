package Lezione8;

import Lezione8.Point2D;

// e nelle classi CP e PP posso evitare l'implements, in quanto eredi di AbstactPoint2D che già
//implementa
        //////mi consente di non dover scrivere i metodi di Point2D
public abstract class AbstractPoint2D implements Lezione8.Point2D {
    private static final double EPS = 1e-10;

    //per avere un equals comune a CartesianPoint2D e PolarPoint2D
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(this instanceof Point2D p)) return false;

        return p.distance(this) <= EPS;
    }
}
