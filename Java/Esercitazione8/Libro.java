package Esercitazione8;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titolo;
    private String autore;
    private String genere;
    private int anno;
    private boolean disponibile;

    public Libro(String titolo, String autore, String genere, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;

        if (anno < 0) {
            throw new IllegalArgumentException();
        }
        this.anno = anno;

        this.disponibile = true;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        if (anno < 0) {
            throw new IllegalArgumentException();
        }
        this.anno = anno;
    }

    public boolean getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", anno=" + anno +
                ", disponibile=" + disponibile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Libro l)) {
            return false;
        }

        return (titolo.equals(l.titolo)) && (autore.equals(l.autore)) && (anno == l.anno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore, anno);
    }

    @Override
    public int compareTo(Libro l) {
        return titolo.compareToIgnoreCase(l.titolo);
    }
}
