package Lezione18;

public record CartaNapoletana(Valore valore, Seme seme) {
    @Override
    public String toString() {
        return valore + " di " + seme;
    }
}
