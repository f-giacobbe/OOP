package Esercitazione3;

public class Moto extends VeicoloManutenzione {
    private int cilindrata;

    public Moto(String marca, String modello, int anno, String targa, int cilindrata) {
        super(marca, modello, anno, targa);
        this.cilindrata = cilindrata;
    }

    @Override
    public String dettagliVeicolo() {
        return super.dettagliVeicolo() + this.cilindrata + " cilindrata";
    }

    @Override
    public void eseguiManutenzione() {
        System.out.println("Manutenzione eseguita sulla moto " + this.dettagliVeicolo());
    }
}
