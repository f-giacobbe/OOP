package Lezione4;

public interface Point2D {
    double getX();
    double getY();
    double getMod();
    double getPhase();

    //METODO DI DEFAULT - per evitare di introdurlo dentro la classe
    default double distance(Point2D p) {
        System.out.println("distance di default Point2D");
        double dx = p.getX() - getX();
        double dy = p.getY() - getY();
        return Math.sqrt(dx * dx + dy * dy);
    }


    //METODO STATIC - non può essere overridden all'interno della calsse
    static Point2D makeFromCartesian(double x, double y) {
        return new CartesianPoint2D(x, y);
    }

    static Point2D makeFromPolar(double mod, double ph) {
        return new PolarPoint2D(mod, ph);
    }
}
