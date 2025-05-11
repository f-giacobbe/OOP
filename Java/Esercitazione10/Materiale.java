package Esercitazione10;

import java.io.Serial;
import java.io.Serializable;

public class Materiale implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private int quantita;
    private double prezzoUnitario;

    

    public Materiale(String nome, int quantita, double prezzoUnitario) {
        this.nome = nome;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }



    @Override
    public String toString() {
        return "Materiale{" +
                "nome='" + nome + '\'' +
                ", quantita=" + quantita +
                ", prezzoUnitario=" + prezzoUnitario +
                '}';
    }
}
