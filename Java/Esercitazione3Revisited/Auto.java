package Esercitazione3Revisited;

public class Auto extends VeicoloManutenzione {
    private int numeroPorte;

    public Auto(String targa, String marca, String modello, int anno, int numeroPorte) {
        super(targa, marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }


    @Override
    public void eseguiManutenzione() {
        super.eseguiManutenzione();
        System.out.println("Inoltre, essendo un veicolo di tipo Auto, ho cambiato tutte e 4" +
                "ruote, cambiato il liquido dei tergicristalli e controllato la ruota di scorta");
    }

    @Override
    public String toString() {
        return super.toString() + ", " + numeroPorte + " porte";
    }
}