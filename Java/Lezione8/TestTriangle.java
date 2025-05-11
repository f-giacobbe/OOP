package Lezione8;

public class TestTriangle {
    public static void main(String[] args) {
        BadCartesianPoint2D p1 = new BadCartesianPoint2D(0, 0);
        Point2D p2 = new BadCartesianPoint2D(1, 0);
        Point2D p3 = new BadCartesianPoint2D(0, 1);

        Figure2D t = new Triangle(p1, p2, p3);
        System.out.println(t.area());

        p1.setX(4.0);

        System.out.println(t.area());

        /*L'area è cambiata per via dell'aliasing. Era dunque opportuno, siccome il Triangle
        è basato su un oggetto mutabile (BadCartesianPoint2D), fare una copia profonda.

        Tuttavia, posso "bucare" con:
         */

        ((BadCartesianPoint2D)((Triangle)t).getP1()).setX(4.0);

        /* risolvo RESTITUENDO UNA COPIA anche con i getters
            (meglio in generale classi immutabili)
         */
    }
}
