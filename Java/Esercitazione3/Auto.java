package Esercitazione3;

public class Auto extends VeicoloManutenzione {
    private int numeroPorte;

    public Auto(String marca, String modello, int anno, String targa, int numeroPorte) {
        super(marca, modello, anno, targa);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String dettagliVeicolo() {
        return super.dettagliVeicolo() + " " + numeroPorte + " porte";
    }

    @Override
    public void eseguiManutenzione() {
        System.out.println("Manutenzione eseguita sul veicolo " + this.dettagliVeicolo());
    }
}
