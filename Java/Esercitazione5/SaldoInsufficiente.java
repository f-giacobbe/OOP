package Esercitazione5;

public class SaldoInsufficiente extends RuntimeException {
    public SaldoInsufficiente() {}

    public SaldoInsufficiente(String message) {
        super(message);
    }
}
