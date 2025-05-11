package Esercitazione5;

public class NegativeFund extends RuntimeException {
    public NegativeFund() {}

    public NegativeFund(String message) {
        super(message);
    }
}
