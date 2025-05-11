package Lezione20;

import java.util.LinkedList;
import java.util.Objects;

public class MyCartesianPoint2D extends CartesianPoint2D {
    private String name;
    private LinkedList<String> names;

    public MyCartesianPoint2D(double x, double y, String name) {
        super(x, y);
        Objects.requireNonNull(name);
        this.name = name;
        this.names = new LinkedList<>();
        this.names.add(name);
    }

    public void addName(String n) {
        Objects.requireNonNull(n);
        if (!names.contains(n)) {
            names.add(n);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "[" + names + "]";
    }


    //avendo una LinkedList ridefinisco il clone
    @Override
    public Object clone() {
        //intanto faccio la clonazione della superclasse
        MyCartesianPoint2D cloned = (MyCartesianPoint2D) super.clone();

        cloned.names = (LinkedList<String>) this.names.clone();

        return cloned;
    }
}
