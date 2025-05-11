package Lezione19;

import java.util.LinkedList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class EratosteneStream {
    public static void main(String[] args) {
        final int N = 100;
        List<Integer> prime = new LinkedList<>();
        prime.add(2);
        IntStream
                .iterate(3, n -> n <= N, n -> n + 2)
                .filter(n -> prime.stream().noneMatch(p -> n%p==0))
                .forEach(((IntConsumer) prime::add).andThen(n -> System.out.print(n + " ")));
        System.out.println();


        List<Integer> even = new LinkedList<>();
        IntStream
                .iterate(1, n -> n <= 50, n -> ++n)
                .filter(n -> n % 2 == 0)
                .forEach(even::add);
        System.out.println(even);
    }
}
