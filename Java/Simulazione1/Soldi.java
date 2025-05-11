package Simulazione1;

public interface Soldi extends Comparable<Soldi>, Iterable<Denaro> {
    default double totale() {
        double res = 0;
        for (Denaro d : this) {
            res += d.getValore();
        }
        return res;
    }

    void add(Denaro d);
    void add(Soldi s);
    void sub(Denaro d);

    Soldi paga(Soldi s1, Soldi s2);

    default int compareTo(Soldi s2) {
        return Double.compare(this.totale(), s2.totale());
    }
}
