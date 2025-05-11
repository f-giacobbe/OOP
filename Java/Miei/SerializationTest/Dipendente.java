package Miei.SerializationTest;

import java.io.Serial;
import java.io.Serializable;

public class Dipendente implements Serializable {
    private String nome;
    private String cognome;
    private float stipendio;
    private transient int oreLavorateOggi;
    @Serial
    private static final long serialVersionUID = 1;

    public Dipendente(String nome, String cognome, float stipendio) {
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
    }

    public void aggiungiOraLavorata() {
        oreLavorateOggi++;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "; Cognome:" + cognome + "; Stipendio:" + stipendio + "; Ore lavorate oggi:" + oreLavorateOggi;
    }
}
