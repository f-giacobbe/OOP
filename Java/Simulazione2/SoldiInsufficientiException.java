package Simulazione2;

public class SoldiInsufficientiException extends RuntimeException {
    public SoldiInsufficientiException(String message) {
        super(message);
    }

    public SoldiInsufficientiException() {}
}
