package Lezione4;

public class Main {
    /* ELLIPSIS - posso passargli, oltre all'array, anche più punti in seguito (p1,p2,p3)
    * invece m(Point3D[] ap) dove posso prendere solo un array */
                 /////
    void m(Point2D... ap) {}

                            ////anche qui
    public static void main(String... args) {
        Point2D p1 = new CartesianPoint2D(3,4);
        Point2D p2 = new PolarPoint2D(3,4);

        double d1 = p1.distance(p2);    ///viene eseguito il distance di default dell'interfaccia
        double d2 = p2.distance(p1);    ///viene eseguito il distance overridden dalla classe PolarPoint2D
    }
}
