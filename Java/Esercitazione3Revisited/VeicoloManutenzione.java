package Esercitazione3Revisited;

public abstract class VeicoloManutenzione implements Veicolo, Manutenzione {
    private String targa;
    private String marca;
    private String modello;
    private int anno;

    public VeicoloManutenzione(String targa, String marca, String modello, int anno) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public String getTarga() {
        return targa;
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


    public void eseguiManutenzione() {
        System.out.println("Manutenzione generica eseguita! Olio, freni.");
    }

    public String toString() {
        return "Targa: " + targa + ", Marca: " + marca + ", Modello: " + modello + ", Anno: " + anno;
    }
}
