package Simulazione2;

import java.util.AbstractList;
import java.util.Iterator;

public class MyLC extends AbstractList<Denaro> implements Iterable<Denaro> {
    private MyNode head;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Denaro get(int targetIndex) {
        if (targetIndex >= size || targetIndex < 0) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        for (Denaro d : this) {
            if (i == targetIndex) {
                return d;
            }

            i++;
        }

        throw new Error();
    }

    @Override
    public boolean add(Denaro d) {
        if (d == null || d.getQuantita() == 0) {
            return false;
        }

        MyNode newNode = new MyNode(d, null);
        MyNode it = head;

        if (it == null) {   //se stiamo aggiungendo il primo elemento
            head = newNode;
        } else {
            while (it.getNext() != null) {
                it = it.getNext();
            }

            it.setNext(newNode);
        }

        size++;
        return true;
    }

    @Override
    public Iterator<Denaro> iterator() {
        return new MyLCIterator();
    }


    private class MyLCIterator implements Iterator<Denaro> {
        private MyNode it;

        @Override
        public boolean hasNext() {
            if (it == null) {
                return size > 0;
            }

            return it.getNext() != null;
        }

        @Override
        public Denaro next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }

            if (it == null) {
                it = head;
            } else {
                it = it.getNext();
            }

            return it.getInfo();
        }
    }
}





class MyNode {
    private Denaro info;
    private MyNode next;

    MyNode(Denaro info, MyNode next) {
        this.info = info;
        this.next = next;
    }

    Denaro getInfo() {
        return info;
    }

    MyNode getNext() {
        return next;
    }

    void setInfo(Denaro info) {
        this.info = info;
    }

    void setNext(MyNode next) {
        this.next = next;
    }
}
