package Esercitazione3;

public class Camion extends VeicoloManutenzione {
    private int capacitaCarico;

    public Camion(String marca, String modello, int anno, String targa, int capacitaCarico) {
        super(marca, modello, anno, targa);
        this.capacitaCarico = capacitaCarico;
    }

    @Override
    public String dettagliVeicolo() {
        return super.dettagliVeicolo() + this.capacitaCarico + " di carico massimo";
    }

    public void eseguiManutenzione() {
        System.out.println("Manutenzione eseguita sul camion " + this.dettagliVeicolo());
    }
}
