package Esercitazione5;

public interface BankOperations extends Comparable<BankOperations> {
    boolean deposita(double val);
    boolean preleva(double val);
    double saldo();
}
