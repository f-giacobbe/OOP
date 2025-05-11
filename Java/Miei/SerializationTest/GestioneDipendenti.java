package Miei.SerializationTest;

import java.io.*;
import java.util.ArrayList;

public class GestioneDipendenti {
    private ArrayList<Dipendente> dipendenti;
    private static final String FILEPATH = "Miei/SerializationTest/mieidipendenti.ser";

    public GestioneDipendenti() {
        caricaDipendenti();
    }

    public void caricaDipendenti() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILEPATH));
            dipendenti = (ArrayList<Dipendente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File non trovato o errore riscontrato. Inizializzo lista dipendenti vuota.");
            dipendenti = new ArrayList<>();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void salvaDipendenti() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            oos.writeObject(dipendenti);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void aggiungiDipendente(Dipendente d) {
        dipendenti.add(d);
    }

    public void stampaDipendenti() {
        for (Dipendente d : dipendenti) {
            System.out.println(d);
        }
    }
}
