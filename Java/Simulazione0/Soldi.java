package Simulazione0;

public interface Soldi extends Comparable<Soldi>, Iterable<Denaro>{
    double totale();

    default void add(Soldi s) {
        for (Denaro d : s) {
            this.add(s);
        }
    }

    void add(Denaro d);
    void sub(Denaro d);
    void sub(Soldi s);
    Soldi paga(Soldi s1, Soldi s2);

    @Override
    default int compareTo(Soldi s) {
        return Double.compare(this.totale(), s.totale());
    }
}
