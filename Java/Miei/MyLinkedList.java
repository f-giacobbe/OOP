package Miei;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<T> extends AbstractList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T thingToAdd) {
        Node<T> newNode = new Node<>(thingToAdd, null);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> it = head;
            while (it.next != null) {
                it = it.next;
            }

            it.next = newNode;
        }

        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> it = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return it.info;
            }

            it = it.next;
        }

        throw new IllegalStateException();
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        //se devo rimuovere il primo elemento
        if (index == 0) {
            T thingToRemove = head.info;
            head = head.next;
            size--;
            return thingToRemove;
        }

        //in tutti gli altri casi
        Node<T> it = head;
        for (int i = 0; i < size; i++) {
            if (i == index - 1) {
                T thingToRemove = it.next.info;
                it.next = it.next.next;
                size--;
                return thingToRemove;
            }

            it = it.next;
        }

        throw new IllegalStateException();
    }

    @Override
    public T set(int index, T thingToSet) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> it = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                T previousThing = it.info;
                it.info = thingToSet;
                return previousThing;
            }

            it = it.next;
        }

        throw new IllegalStateException();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }



    public class MyIterator implements Iterator<T> {
        private Node<T> it;

        @Override
        public boolean hasNext(){
            if (it == null) {
                return head != null;
            }

            return it.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }

            if (it == null) {
                it = head;
                return it.info;
            }

            it = it.next;
            return it.info;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int i = 0;
        for (T el : this) {
            sb.append(el);

            if (i < size-1) {
                sb.append(", ");
            }

            i++;
        }

        sb.append("]");
        return sb.toString();
    }
}




class Node<T> implements Cloneable {
    T info;
    Node<T> next;

    Node() {}

    Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        Node<T> n = (Node<T>) o;

        return this.info.equals(n.info) && this.next == n.next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, next);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}