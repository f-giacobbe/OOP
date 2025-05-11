package Miei;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 7, 2);

        Stream<Integer> streamPari = l.stream()
                .filter(n -> n % 2 == 0);
        streamPari.forEach(n -> System.out.print(n + " "));

        System.out.println();

        Stream<Integer> streamQuadratiOrdinatiDecrescenti = l.stream()
                .sorted((n1, n2) -> {return n2.compareTo(n1);})
                .map(n -> n * n);
        //streamQuadratiOrdinatiDecrescenti.forEach(n -> System.out.print(n + " "));


        List<Integer> listaCopiataDaStream = streamQuadratiOrdinatiDecrescenti.toList();
        System.out.println(listaCopiataDaStream);
    }
}
