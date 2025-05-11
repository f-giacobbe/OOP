package Simulazione2;

public interface Denaro extends Comparable<Denaro> {
    float getValore();
    int getQuantita();

    default double getSomma() {
        return getValore() * getQuantita();
    }

    void setQuantita(int q);

    @Override
    default int compareTo(Denaro d) {
        return Float.compare(this.getValore(), d.getValore());
    }

    Taglio getTaglio();
}