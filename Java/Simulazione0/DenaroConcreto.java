package Simulazione0;

import java.util.Objects;

public class DenaroConcreto implements Denaro{
    private final Taglio valore;
    private int quantita;

    public DenaroConcreto(float valore, int quantita) {
        this.valore = Taglio.findByValue(valore);   //throws IllegalArgumentException
        if (quantita < 0) {
            throw new IllegalArgumentException();
        }
        this.quantita = quantita;
    }

    public float getValore() {
        return valore.getValore();
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Denaro d)) {
            return false;
        }

        return Float.compare(this.getValore(), d.getValore()) == 0 && this.quantita == d.getQuantita();
    }

    @Override
    public String toString() {
        return "[Valore:" + valore + ",Quantità:" + quantita + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore, quantita);
    }
}
