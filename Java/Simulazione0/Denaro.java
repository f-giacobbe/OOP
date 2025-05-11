package Simulazione0;

public interface Denaro extends Comparable<Denaro> {
    float getValore();
    int getQuantita();
    void setQuantita(int quantita);

    @Override
    default int compareTo(Denaro d2) {
        return Float.compare(this.getValore(), d2.getValore());
    }

    default float getSomma() {
        return getValore() * getQuantita();
    }
}
