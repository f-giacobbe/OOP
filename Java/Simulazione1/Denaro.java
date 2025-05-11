package Simulazione1;

public interface Denaro extends Comparable<Denaro>{
    public float getValore();
    public int getQuantita();

    default double getSomma() {
        return getQuantita() * getValore();
    }

    public void setQuantita(int quantita);

    default int compareTo(Denaro d2) {
        return Float.compare(this.getValore(), d2.getValore());
    }
}
