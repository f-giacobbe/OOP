package Esercitazione3Revisited;

public class Moto extends VeicoloManutenzione {
    private int cilindrata;

    public Moto(String targa, String marca, String modello, int anno, int cilindrata) {
        super(targa, marca, modello, anno);
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }


    @Override
    public void eseguiManutenzione() {
        super.eseguiManutenzione();
        System.out.println("Inoltre, essendo un veicolo di tipo Moto, è stata anche lubrificata" +
                "la catena");
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindrata: " + cilindrata;
    }
}
