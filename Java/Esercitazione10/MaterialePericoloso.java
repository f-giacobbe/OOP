package Esercitazione10;

public class MaterialePericoloso extends Materiale {
    private final int classePericolo;


    public MaterialePericoloso(String nome, int quantita, double prezzoUnitario, int classePericolo) {
        super(nome, quantita, prezzoUnitario);
        this.classePericolo = classePericolo;
    }


    @Override
    public String toString() {
        return "Materiale{" +
                "nome='" + super.getNome() + '\'' +
                ", quantita=" + super.getQuantita() +
                ", prezzoUnitario=" + super.getPrezzoUnitario() +
                ", classePericolo=" + this.classePericolo +
        '}';
    }
}
