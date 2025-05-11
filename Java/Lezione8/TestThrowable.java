package Lezione8;

public class TestThrowable {
                                           //////////////// in caso di Throwable
    public static void main(String[] args) /*throws Throwable*/ {
        /* Throwable tr = new Throwable("Vai via!!");
        throw tr; */

        RuntimeException tr = new RuntimeException("Vai via!!");
        throw tr;
    }
}
