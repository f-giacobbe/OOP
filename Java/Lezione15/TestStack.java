package Lezione15;

import oop.range.*;

import java.util.ArrayList;
import java.util.List;

public class TestStack {
    public static void main(String[] args) {
        Range r = new Range(0,10);
        Stack<Integer> stack = new UnboundedArrayStack<>(150);
        stack.pushAll(r);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }



        Stack<Number> stack2 = new UnboundedArrayStack<>(150);
        //stack2.pushAll(r);        NON POSSO PERCHé VUOLE UN Iterable<Number>
        /* perché prende un Iterable<E> ed esattamente E */
        /* quando invece il metodo prende un Iterable<? extends E> va bene */
        for (Integer i : r) {
            stack2.push(i);
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }



        List<Double> list = new ArrayList<>();
        list.add(6.9);
        list.add(3.5);
        stack2.pushAll(list);       //va bene perché Double extends Number




        Stack<Integer> stack3 = new UnboundedArrayStack<>(150);
        stack3.pushAll(r);

        ArrayList<Number> al = new ArrayList<>();
        stack3.popAll(al);
        System.out.println(al);
    }
}
