package Lezione12;

public interface Stack<E> {
    void push(E item);
    E pop();
    E top();
    int size();
    boolean isEmpty();
    boolean isFull();
}
