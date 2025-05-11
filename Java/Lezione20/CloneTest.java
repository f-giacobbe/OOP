package Lezione20;

import java.util.LinkedList;

public class CloneTest {
    public static void main(String[] args) {
        CartesianPoint2D p = new CartesianPoint2D(3, 4);
        CartesianPoint2D pClone = (CartesianPoint2D) p.clone();

        System.out.println(p);
        System.out.println(pClone);




        MyCartesianPoint2D mp = new MyCartesianPoint2D(5, 6, "p1");
        System.out.println(mp);

        /////////////non My
        CartesianPoint2D cp = (CartesianPoint2D) mp.clone();
        System.out.println(cp);
        //ma comunque
        System.out.println(cp.getClass());



        //partiamo dal presupposto che String non è Cloneable
        LinkedList<String> l1 = new LinkedList<>();
        l1.add("pippo");
        l1.add("topolino");
        l1.add("pluto");

        var l2 = l1.clone();

        l1.removeFirst();
        System.out.println(l1);
        System.out.println(l2);     //l2 rimane uguale, quindi la clonazione è profonda
    }
}
