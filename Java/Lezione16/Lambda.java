package Lezione16;

import Lezione15.Person;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        String[] as = {"aaaaa", "bfdsf", "fdsfsdf", "assas", "lsldl"};


        //creo un comparatore anonimo in base alla lunghezza delle stringhe
        /* mi assicuro di avere un ordinamento totale, ovvero, a parità di lunghezza, considero
        la compare "naturale"
         */
        Comparator<String> comp = (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            }

            if (s1.length() > s2.length()) {
                return 1;
            }

            return s1.compareTo(s2);
        };



        //LAMBDA che sostituisce l'unico metodo astratto del Comparator (compare)
        TreeSet<String> set = new TreeSet<>(
                //non è neache necessario specificare i tipi
                (s1, s2) -> {
                    if (s1.length() < s2.length()) {
                        return -1;
                    }

                    if (s1.length() > s2.length()) {
                        return 1;
                    }

                    return s1.compareTo(s2);
                }
        );

        Collections.addAll(set, as);
        System.out.println(set);




                    //  METHOD REFERENCE
        comp = String :: compareToIgnoreCase;

        int k = comp.compare("alpha", "beta");
        System.out.println(k);






        String[] as1 = {"a", "b", "c"};
        Person[] ap1 = buildFromID(as1, Person :: new);
        for (Person p : ap1) {
            System.out.println(p);
        }

        //oppure usando le lambda
        Person[] ap2 = buildFromID(as1, s -> {
            return new Person(s);
        });




        //forEach per gli Iterable
        set.forEach(System.out :: println);
    }

    static Person[] buildFromID(String[] iterable, Function<String, Person> f) {
        ArrayList<Person> ap = new ArrayList<>();

        for (String str : iterable) {
            ap.add(f.apply(str));
        }

        return ap.toArray(new Person[ap.size()]);
    }
}
