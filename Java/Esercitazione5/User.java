package Esercitazione5;

import java.util.ArrayList;

public class User {
    private String codice;
    private String nome;
    private String cognome;
    private ArrayList<AbstractBankingAccount> listaConti;

    public User(String codice, String nome, String cognome, ArrayList<AbstractBankingAccount> listaConti) {
        if (codice.charAt(0) != 'U')
            throw new InvalidUserIDException("Codice utente non valido (ricorda che deve " +
                "iniziare per U");

        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.listaConti = listaConti;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public ArrayList<AbstractBankingAccount> getListaConti() {
        return listaConti;
    }

    public void addConto(AbstractBankingAccount conto) {
        if (this.listaConti.contains(conto)) {
            throw new AlreadyRegisteredAccountException("Conto già associato al cliente");
        }
    }
}
