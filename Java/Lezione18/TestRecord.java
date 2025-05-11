package Lezione18;

public class TestRecord {
    public static void main(String[] args) {
        Punto p1 = new Punto(3.1, 4.0);
        double x = p1.x();
        double y = p1.y();
        Punto p2 = new Punto(3.1, 4.0);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1 è uguale a p2?: " + p1.equals(p2));  //true, anche se sono oggetti
                                                                    //diversi
        //hashCode uguali
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());

    }
}
