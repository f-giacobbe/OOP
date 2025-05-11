package Lezione13;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedContainer<E> extends AbstractContainer<E> {
    private Node<E> head;
    private Node<E> tail;


    @Override
    public E set(int index, E elem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        //se aggiungo in ultima posizione oppure lista vuota
        if (index == size) {
            add(elem);
            return null;
        }

        int m = size/2;
        int k = 0;
        Node<E> cur = null;
        if (index < m) {
            cur = head;
            while (cur != null && k < index) {
                cur = cur.next;
                k++;
            }
        } else {
            cur = tail;
            k = size-1;
            while (cur != null && k > index) {
                cur = cur.prev;
                k--;
            }
        }

        E e = cur.info;
        cur.info = elem;
        return e;
    }



    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        final int m = size >> 1;    //diviso 2
        int k=0;
        Node<E> cur=null;
        if(index<m){
            k=0;
            cur=head;
            while (k<index){
                cur=cur.next;
                k++;
            }
        }else {

            k=size-1;
            cur=tail;
            while (k>index){
                cur= cur.prev;
                k--;
            }
        }
        return cur.info;
    }



    @Override
    public boolean add(E elem) {
        Node<E> newNode = new Node<>(elem, tail, null);

        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }

        tail = newNode;

        size++;
        return true;
    }



    //farlo per esercizio con un puntatore
    public void add(int index, E elem) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException();

        if (index == size) {
            add(elem);
            return;
        }

        int m  = size/2;
        int k = 0;
        Node<E> cur = null;

        if (index < m) {
            cur = head;

            while (cur != null && k < index) {
                cur = cur.next;
                k++;
            }

        } else {
            cur = tail;

            k = size-1;
            while (cur != null && k > index) {
                cur = cur.prev;
                k--;
            }
        }

        Node<E> newNode = new Node<>(elem, cur.prev, cur);

        if (cur == head) {
            head = newNode;
        } else {
            cur.prev.next = newNode;
        }


        cur.prev = newNode;

        size++;
    }



    @Override
    public Iterator<E> iterator() {
        return new DLCIterator();
    }

    private class DLCIterator implements Iterator<E> {
        private Node<E> cur;
        private boolean removeOK = false;


        @Override
        public boolean hasNext() {
            if (cur == null) {
                return head != null;
            }

            return cur.next != null;
        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            //prev = cur;

            if (cur == null) {
                cur = head;
            } else {
                cur = cur.next;
            }

            E res = cur.info;

            removeOK = true;
            return res;
        }


        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }

            removeOK = false;

            if (cur == head) {
                head = head.next;
            } else {
                cur.prev.next = cur.next;

            }

            if (cur == tail) {
                tail = cur.prev;
            } else {
                cur.next.prev = cur.prev;
            }


            size--;
        }
    }



    public ListIterator<E> listIterator() {
        return new DLCListIterator();
    }

    private class DLCListIterator implements ListIterator<E> {
        private Node<E> cur;
        private boolean removeOKfromNext = false;
        private boolean removeOKfromPrevious = false;
        private int curIndex = -1;


        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the forward direction. (In other words,
         * returns {@code true} if {@link #next} would return an element rather
         * than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the forward direction
         */
        @Override
        public boolean hasNext() {
            if (cur == null) {
                return head != null;
            }

            return cur.next != null;
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * This method may be called repeatedly to iterate through the list,
         * or intermixed with calls to {@link #previous} to go back and forth.
         * (Note that alternating calls to {@code next} and {@code previous}
         * will return the same element repeatedly.)
         *
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (cur == null) {
                cur = head;
            } else {
                cur = cur.next;
            }

            removeOKfromNext = true;
            removeOKfromPrevious = false;
            curIndex++;
            return cur.info;
        }

        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words,
         * returns {@code true} if {@link #previous} would return an element
         * rather than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the reverse direction
         */
        @Override
        public boolean hasPrevious() {
            if (removeOKfromNext) {  //removeOK true perché se ho fatto la remove potrei non avere l'elemento prima
                return true;
            }

            if (cur != null) {
                return cur.prev != null;
            }

            return false;
        }

        /**
         * Returns the previous element in the list and moves the cursor
         * position backwards.  This method may be called repeatedly to
         * iterate through the list backwards, or intermixed with calls to
         * {@link #next} to go back and forth.  (Note that alternating calls
         * to {@code next} and {@code previous} will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list
         * @throws NoSuchElementException if the iteration has no previous
         *                                element
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            E res = cur.info;
            cur = cur.prev;
            removeOKfromPrevious = true;
            removeOKfromNext = false;
            curIndex--;
            return res;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #next}. (Returns list size if the list
         * iterator is at the end of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code next}, or list size if the list
         * iterator is at the end of the list
         */
        @Override
        public int nextIndex() {
            return curIndex+1;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #previous}. (Returns -1 if the list
         * iterator is at the beginning of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code previous}, or -1 if the list
         * iterator is at the beginning of the list
         */
        @Override
        public int previousIndex() {
            return curIndex;
        }

        /**
         * Removes from the list the last element that was returned by {@link
         * #next} or {@link #previous} (optional operation).  This call can
         * only be made once per call to {@code next} or {@code previous}.
         * It can be made only if {@link #add} has not been
         * called after the last call to {@code next} or {@code previous}.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this list iterator
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void remove() {
            if (!(removeOKfromNext || removeOKfromPrevious)) {
                throw new IllegalStateException();
            }

            if (removeOKfromNext) {
                curIndex--;
                if (cur == head) {
                    head = cur.next;
                } else {
                    cur.prev.next = cur.next;
                }

                if (cur == tail) {
                    tail = cur.prev;
                } else {
                    cur.next.prev = cur.prev;
                }

                removeOKfromNext = false;
            } else {    //removeOKfromPrevious
                //head or solo
                if (cur == null || size == 1) {
                    head = head.next;

                    if (head.next != null) {
                        head.next.prev = null;
                    }

                    if (size == 1) {
                        tail = null;
                    }
                } else {
                    //tail
                    if (cur.next.next == null) {
                        tail = cur;
                    }

                    cur.next = cur.next.next;
                }

                removeOKfromPrevious = false;
            }

            size--;
        }

        /**
         * Replaces the last element returned by {@link #next} or
         * {@link #previous} with the specified element (optional operation).
         * This call can be made only if neither {@link #remove} nor {@link
         * #add} have been called after the last call to {@code next} or
         * {@code previous}.
         *
         * @param e the element with which to replace the last element returned by
         *          {@code next} or {@code previous}
         * @throws UnsupportedOperationException if the {@code set} operation
         *                                       is not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of the specified
         *                                       element prevents it from being added to this list
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void set(E e) {
            if (!(removeOKfromNext || removeOKfromPrevious)) {
                throw new IllegalStateException();
            }

            if (removeOKfromNext) {
                cur.info = e;
            } else {
                cur.next.info = e;
            }
        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that
         * would be returned by {@link #next}, if any, and after the element
         * that would be returned by {@link #previous}, if any.  (If the
         * list contains no elements, the new element becomes the sole element
         * on the list.)  The new element is inserted before the implicit
         * cursor: a subsequent call to {@code next} would be unaffected, and a
         * subsequent call to {@code previous} would return the new element.
         * (This call increases by one the value that would be returned by a
         * call to {@code nextIndex} or {@code previousIndex}.)
         *
         * @param e the element to insert
         * @throws UnsupportedOperationException if the {@code add} method is
         *                                       not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of this element
         *                                       prevents it from being added to this list
         */
        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e, null, null);

            if (size == 0) {
                head = newNode;
                tail = newNode;

            } else {

                if (hasPrevious()) {
                    cur.next = newNode;
                    newNode.prev = cur;

                    if (cur == tail) {
                        tail = newNode;
                    }
                }

                if (hasNext() && cur != null) {
                    cur.next.prev = newNode;
                    newNode.next = cur.next.prev;
                }

                if (cur == null) {
                    head.prev = newNode;
                    newNode.next = head;
                    head = newNode;
                }
            }


            cur = newNode;
            curIndex++;
            removeOKfromPrevious = false;
            removeOKfromNext = false;
            size++;
        }
    }



    private static class Node<E> {
        E info;
        Node<E> prev;
        Node<E> next;

        public Node(E info, Node<E> prev, Node<E> next) {
            this.info = info;
            this.prev = prev;
            this.next = next;
        }
    }
}
