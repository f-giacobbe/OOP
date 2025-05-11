package Lezione3;
import static java.lang.Math.*;

/* per implementare l'interfaccia faccio come segue: (per mantenere la promessa TOTALMENTE)*/

                              ////////////////// posso anche implementare più interfacce
public class CartesianPoint2D implements Point2D {
    private double x;
    private double y;

    
    public CartesianPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CartesianPoint2D() {}

    @Override
    public double distance(Point2D p) {
        /* non posso usare p.x in quanto NON è di tipo CartesianPoint2D, ma si rifà all'interfaccia Point2D
         * che NON ha una variabile di istanza x (o y)
         */
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        return sqrt(dx*dx + dy*dy);
    }

    @Override
    public double getMod() {
        return sqrt(x*x + y*y);
    }

    @Override
    public double getPhase() {
        return atan2(y, x);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }
    
}
