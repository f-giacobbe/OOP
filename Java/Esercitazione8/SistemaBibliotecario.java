package Esercitazione8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SistemaBibliotecario {
    private ArrayList<Libro> libri; //in ordine di inserimento
    private HashMap<Libro, String> prestiti;    //libro, nome borrower

    public void aggiungiLibro(Libro l) {
        libri.add(l);
        System.out.println("Libro aggiunto con successo!\n" + l);
    }

    public void cercaPerTitolo(String titolo) {
        LinkedList<Libro> res = new LinkedList<>();

        for (Libro l : libri) {
            if (l.getTitolo().equalsIgnoreCase(titolo)) {
                res.add(l);
            }
        }

        if (res.isEmpty()) {
            System.out.println("Nessun risultato.");
        } else {
            System.out.println("Risultati trovati:\n");
            res.forEach(System.out::println);
        }
    }

    public void cercaPerAutore(String autore) {
        LinkedList<Libro> res = new LinkedList<>();

        for (Libro l : libri) {
            if (l.getAutore().equalsIgnoreCase(autore)) {
                res.add(l);
            }
        }

        if (res.isEmpty()) {
            System.out.println("Nessun risultato.");
        } else {
            System.out.println("Risultati trovati:\n");
            res.forEach(System.out::println);
        }
    }

    public void ordinaPerTitolo() {
        ArrayList<Libro> res = (ArrayList)libri.clone();
        res.sort(Libro::compareTo);
        res.forEach(System.out::println);
    }

    public void ordinaPerAnno() {
        //(dal più recente)
        ArrayList<Libro> res = (ArrayList)libri.clone();
        res.sort( (l1, l2) -> {
            return Integer.compare(l2.getAnno(), l1.getAnno());
        } );
        res.forEach(System.out::println);
    }

    public void stampaCatalogo() {
        System.out.println(libri);
    }

    public boolean presta(Libro l, String nome) {
        if (!l.getDisponibile()) {
            return false;
        }

        prestiti.put(l, nome);
        l.setDisponibile(false);
        return true;
    }

    public boolean restituzione(Libro l) {
        if (!prestiti.containsKey(l)) {
            return false;
        }

        prestiti.remove(l);
        l.setDisponibile(true);
        return true;
    }
}
