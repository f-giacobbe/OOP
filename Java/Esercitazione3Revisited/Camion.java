package Esercitazione3Revisited;

public class Camion extends VeicoloManutenzione {
    private double capacitaCarico;
    private int assi;

    public Camion(String targa, String marca, String modello, int anno, double capacitaCarico, int assi) {
        super(targa, marca, modello, anno);
        this.capacitaCarico = capacitaCarico;
        this.assi = assi;
    }


    public double getCapacitaCarico() {
        return capacitaCarico;
    }

    public int getAssi() {
        return assi;
    }


    @Override
    public void eseguiManutenzione() {
        super.eseguiManutenzione();
        System.out.println("Inoltre, essendo un veicolo di tipo Camion, è stata effettuata" +
                "la manutenzione anche sul rimorchio e sui vari sistemi specifici, tipo retarder");
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacità di carico: " + capacitaCarico;
    }
}
