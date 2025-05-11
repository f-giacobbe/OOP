package Simulazione1;

import java.util.Objects;

public abstract class DenaroAbstract implements Denaro {
    private final float valore;
    private int quantita;

    /* con questo costruttore, prendendo in input un oggetto di tipo Taglio, è impossibile
     * inserire un valore con conforme; dunque non è necessaria la gestione delle eccezioni*/
    protected DenaroAbstract(Taglio taglio, int quantita) {
        this.valore = taglio.getValore();
        this.quantita = quantita;
    }

    @Override
    public float getValore() {
        return valore;
    }

    @Override
    public int getQuantita() {
        return quantita;
    }

    @Override
    public void setQuantita(int quantita) {
        if (quantita < 0) {
            throw new RuntimeException("Quantità non può essere negativa");
        }

        this.quantita = quantita;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Denaro d2)) {
            return false;
        }

        return Float.compare(this.getValore(), d2.getValore()) == 0 &&
                this.getQuantita() == d2.getQuantita();
    }

    @Override
    public String toString() {
        return "[Denaro - Valore:" + getValore() + ",Quantità:" + getQuantita();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.valore, this.quantita);
    }
}
