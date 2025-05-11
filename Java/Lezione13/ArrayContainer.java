package Lezione13;

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayContainer<E> extends AbstractContainer<E> {
    private Object[] array = new Object[10];


    @Override
    public E set(int index, E elem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == size) {
            add(elem);
            return null;
        }

        E res = (E) array[index];
        array[index] = elem;
        return res;
    }

    @Override
    public boolean add(E elem) {
        if (size == array.length-1) {
            reallocate();
        }

        array[size] = elem;
        size++;
        return true;
    }

    private void reallocate() {
        Object[] newArray = Arrays.copyOf(array, array.length*2);
        array = newArray;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ACIterator();
    }


    private class ACIterator implements Iterator<E> {
        private int i = -1;
        private boolean removeOK = false;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return size-1 > i;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            removeOK = true;
            i++;
            return (E) array[i];
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }

            for (int j = i; j < size-1; j++) {
                array[j] = array[j+1];
            }

            removeOK = false;
            size--;
            i--;

            //svuoto la fine
            array[size] = null;
        }
    }
}
