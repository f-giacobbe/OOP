package Simulazione2;

import java.util.Objects;

public abstract class DenaroAstratto implements Denaro, Cloneable {
    private Taglio taglio;
    private int quantita;

    /*
    Non è necessaria la gestione dell'eccezione qualora si tenti di creare un oggetto Denaro di un taglio
    differente in quanto prendendo come parametro un oggetto Taglio, che è un enum, controllo io i tagli
    permessi.
     */
    protected DenaroAstratto(Taglio t, int quantita) {
        this.taglio = t;

        if (quantita < 0) {
            throw new IllegalArgumentException();
        }

        this.quantita = quantita;
    }

    @Override
    public float getValore() {
        return taglio.getValore();
    }

    @Override
    public int getQuantita() {
        return quantita;
    }

    @Override
    public void setQuantita(int q) {
        if (q < 0) {
            throw new IllegalArgumentException();
        }

        quantita = q;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof Denaro d)) {
            return false;
        }

        return Float.compare(this.getValore(), d.getValore()) == 0;
    }

    @Override
    public String toString() {
        return "Valore:" + taglio.getValore() + "; Quantità:" + quantita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taglio);
    }

    public Taglio getTaglio() {
        return taglio;
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
