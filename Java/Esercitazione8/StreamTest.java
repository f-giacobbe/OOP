package Esercitazione8;

import java.util.Comparator;
import java.util.stream.*;
import java.util.List;
import java.util.Arrays;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(4, 5, 2, 9, 1);

        Stream<Integer> evenStream = l.stream()
                .filter(n -> n % 2 == 0);

        evenStream.forEach(System.out::println);
//      evenStream.forEach(System.out::println);    VIENE "CONSUMATO" DOPO L'USO
        System.out.println(l);  //la lista originale rimane intaccata



        //oppure se voglio solo stampare (forEach restituisce void, non mi serve salvarlo
        //in una variabile)
        l.stream()
                .sorted((n1, n2) -> {return n2.compareTo(n1);})
                .map(n -> n*n)
                .forEach(System.out::println);
    }
}
