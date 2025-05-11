package Lezione12;

public class BoundedStack<E> implements Stack<E> {
    private final Object[] data;
    private int topIndex;
    
    public BoundedStack(final int cap) {
        if (cap < 0) throw new IllegalArgumentException();
        
        data = new Object[cap];
        //topIndex = 0;
    }
    
    public BoundedStack() {
        data = new Object[10];
    }


    @Override
    public void push(E item) {
        if (isFull()) throw new FullStackException();

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
    public boolean isEmpty() {
        return topIndex == 0;
    }


    @Override
    public boolean isFull() {
        return topIndex == data.length;
    }


    @Override
    public int size() {
        return topIndex;
    }


    public int capacity() {
        return data.length;
    }
}
