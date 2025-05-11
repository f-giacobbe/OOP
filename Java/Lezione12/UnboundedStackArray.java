package Lezione12;

public class UnboundedStackArray<E> implements Stack<E> {
    private Object[] data;
    private int topIndex;
    public static final int MIN_CAP = 10;

    public UnboundedStackArray(int cap) {
        data = new Object[Math.max(cap, MIN_CAP)];
    }


    public UnboundedStackArray() {
        data = new Object[10];
    }


    @Override
    public void push(E item) {
        if (topIndex == data.length) {
            reallocate();
        }

        data[topIndex] = item;
        topIndex++;
    }


    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();

        topIndex--;
        return (E)data[topIndex];   //sappiamo che inseriamo solo elementi di tipo E
    }


    @Override
    public E top() {
        if (isEmpty()) throw new EmptyStackException();

        return (E)data[topIndex-1];
    }


    @Override
    public boolean isFull() {
        return topIndex == Integer.MAX_VALUE;
    }


    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }


    @Override
    public int size() {
        return topIndex;
    }


    public int capacity() {
        return data.length;
    }


    private void reallocate() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
    /* tuttavia meglio usare una struttura dati di tipo concatenata (in quanto non accediamo
    in posizione ma solo in testa
     */
}
