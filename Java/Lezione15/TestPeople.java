package Lezione15;

import java.sql.Array;
import java.util.ArrayList;

public class TestPeople {
    public static void main(String[] args) {
        Person pippo = new Person("33232");
        Person pluto = new Person("12345");
        Person topolino = new Person("00123");

        System.out.println(pluto.compareTo(topolino));




        Student cenzucalogero = new Student("00001");

        System.out.println(cenzucalogero.compareTo(topolino));
        System.out.println(topolino.compareTo(cenzucalogero));


        ArrayList<Person> al = new ArrayList<>();
        al.add(pippo);
        al.add(pluto);
        al.add(topolino);
        al.add(cenzucalogero);
        System.out.println(PeopleUtil.min(al));


        ArrayList<Student> as = new ArrayList<>();
        as.add(cenzucalogero);
        as.add(new Student("1562"));
        as.add(new Student("0000"));
        System.out.println(PeopleUtil.min(as));
    }
}
