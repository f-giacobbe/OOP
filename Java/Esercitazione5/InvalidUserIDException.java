package Esercitazione5;

public class InvalidUserIDException extends IllegalArgumentException {
    public InvalidUserIDException() {}

    public InvalidUserIDException(String s) {
        super(s);
    }
}
