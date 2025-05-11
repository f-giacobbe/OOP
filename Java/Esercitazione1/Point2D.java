package Esercitazione1;

public class Point2D {
    private double x;
    private double y;
    public static double EPS = 1e-10;
    public static double PI = 3.1415;

    public Point2D(){}

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distance(Point2D p) {
        return Math.sqrt( Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2) );
    }

    public double getArea(Point2D centro, Point2D a) {
        double raggio = centro.distance(a);
        return raggio*raggio*PI;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        Point2D p = (Point2D) o;
        
        return this.distance(p) <= EPS;
    }

    public static boolean areAligned(Point2D a, Point2D b, Point2D c) {
        /* se i coefficienti angolari dei segmenti AB e AC sono uguali */
        return ( (c.getX() - a.getX()) * (b.getY() - a.getY()) == (c.getY() - a.getY()) * (b.getX() - a.getX()) );
    }

    public static boolean arePerpendicular(Point2D a, Point2D b, Point2D c) {
        /* se il prodotto scalare tra i vettori AB e BC è nullo */
        double dotProduct = (b.getX() - a.getX()) * (c.getX() - b.getX()) + (b.getY() - a.getY()) * (c.getY() - b.getY());

        return dotProduct == 0;
    }

    public static boolean isEquidistant(Point2D a, Point2D b, Point2D c) {
        Double d_a = c.distance(a);
        Double d_b = c.distance(b);

        return Math.abs(d_a - d_b) < EPS;
    }

    public static boolean isSquare(Point2D a, Point2D b, Point2D c, Point2D d) {
        double ab = a.distance(b);
        double bc = b.distance(c);
        double cd = c.distance(d);
        double da = d.distance(a);

        boolean sameLength = Math.abs(ab - bc) < EPS && Math.abs(bc - cd) < EPS && Math.abs(cd - da) < EPS;

        return sameLength && arePerpendicular(a, b, c);
    }
}
