package Esercitazione3;

import java.util.Random;

public abstract class VeicoloManutenzione implements Manutenzione, Veicolo {
    /* contiene i metodi di Manutenzione e di Veicolo */
    private String marca;
    private String modello;
    private int anno;
    private String targa;

    public VeicoloManutenzione(String marca, String modello, int anno, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getAnno() {
        return anno;
    }

    public String getTarga() {
        return targa;
    }

    public String dettagliVeicolo() {
        return this.marca + " " + this.modello + " " + this.anno + " " + this.targa;
    }

    public String toString() {
        return this.marca + " " + this.modello + " " + this.anno + " " + this.targa;
    }

    public int stimaProssimaManutenzione() {
        Random rand = new Random();
        return rand.nextInt(0, 15000);
    }
}
