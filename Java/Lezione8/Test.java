package Lezione8;

import java.util.Scanner;

public class Test {
                                            ///////////////////////////////può
                                            //potenzialmente rilanciare una
    public static void main(String[] args) throws IllegalArgumentException {
        Rectangle r = new Rectangle(4, 5);

        double a1 = r.area();
        //r.setBase(r.getBase() * 2.0);

        double a2 = r.area();

        boolean b = a2 == a1*2.0;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b);


        Square s = new Square(4);
        r = s;

        a1 = r.area();
        //r.setBase(r.getBase() * 2.0);
        a2 = r.area();
        b = a2 == a1*2.0;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b);

        System.out.println("s è un quadrato: " + (s.getBase() == s.getHeight()));   //false
        /* abbiamo alterato la base attraverso un metodo di Rectangle)
        *
        * aggiungendo gli Override a Square dei setters, quest'ultimo controllo esce TRUE,
        * tuttavia b esce FALSE
        *
        * La soluzione è rendere Square indipendente da Rectangle, a meno che non rendiamo
        * Rectangle immutabile (togliendo i setters) perché a Rectangle posso farlo, mentre
        * a Square no (non vale quindi il principio di Liskov
        *
        * Quindi capiamo che la correttezza dipende unicamente da come DEFINIAMO NOI le classi */



        //gestione di un'eccezione
        Scanner scanner = new Scanner(System.in);

        boolean ok = false;

        Circle circle = null;

        do {
            System.out.println("Radius: ");
            double radius = scanner.nextDouble();

            try {
                circle = new Circle(radius);    //punto di potenziale eccezione
                ok = true;
            } catch (IllegalArgumentException e) {
                System.out.println("radius must be positive, try again");
            }

        } while (!ok);

        System.out.println("L'area del cerchio è: " + circle.area());

        /* in questo caso però è inutile, perché ogni volta tenta di crearmi un nuovo cerchio;
        sarebbe più opportuno verificare con un semplice if
         */
        ok = false;
        scanner.nextLine();
        do {
            System.out.println("Radius: ");
            double radius = scanner.nextDouble();

            if (radius >= 0) {
                circle = new Circle(radius);
                ok = true;
            } else {
                System.out.println("radius must be positive, try again");
            }

        } while (!ok);



        ok = false;
        scanner.nextLine();
        do {
            System.out.println("Radius: ");
            double radius = scanner.nextDouble();

            try {
                circle = new Circle(radius);
                ok = true;
            } catch (NegativeRadiusException e) {
                System.out.println("radius must be positive, try again");

                /*RILANCIO ECCEZIONE (gestione parziale dell'eccezione) - utile nel caso di
                CHECKED exceptions
                 */
                throw e;

            ///////////
            //codice che viene eseguito COMUNQUE (anche se viene rilanciata l'eccezione)
            } finally {
                System.out.println("sto creando cerchi veri");
            }

        } while (!ok);
    }
}
