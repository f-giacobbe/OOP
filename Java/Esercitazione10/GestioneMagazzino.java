package Esercitazione10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestioneMagazzino implements Serializable {
    private static final String FILE_PATH = "Esercitazione10/miomagazzino.dat";
    @Serial
    private static final long serialVersionUID = -7900356181773244794L;
    private List<Materiale> magazzino;
    


    public GestioneMagazzino() {
        this.magazzino = caricaMagazzino();
    }



    public List<Materiale> caricaMagazzino() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
            System.out.println("\nMagazzino caricato da " + FILE_PATH);
            return (List<Materiale>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("\nFile non trovato o errore durante il caricamento. Inizializzazione magazzino vuoto");
            return new ArrayList<>();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.err.println("\nErrore durante chiusura ObjectInputStream" + e.getMessage());
            }
        }
    }


    public void salvaMagazzino() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
            oos.writeObject(magazzino);
            System.out.println("Magazzino salvato correttamente!");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio. " + e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.err.println("Errore durante chiusura ObjectOutputStream. " + e.getMessage());
            }
        }
    }


    public void aggiungiMateriale(String nome, int quantita, double prezzoUnitario) {
        magazzino.add(new Materiale(nome, quantita, prezzoUnitario));
        System.out.println("Materiale aggiunto");
    }


    public void aggiungiMaterialePericoloso(String nome, int quantita, double prezzoUnitario, int classePericolo) {
        magazzino.add(new MaterialePericoloso(nome, quantita, prezzoUnitario, classePericolo));
        System.out.println("Materiale aggiunto");
    }


    public void visualizzaMagazzino() {
        if (magazzino.isEmpty()) {
            System.out.println("Magazzino vuoto");
            return;
        }

        for (Materiale m : magazzino) {
            System.out.println(m);
        }
    }


    public static void main(String[] args) {
        GestioneMagazzino gestioneMagazzino = new GestioneMagazzino();

        Scanner sc = new Scanner(System.in);

        int scelta;
        do {
            System.out.println("""
                    \n---Menu gestione magazzino---
                    1) Aggiungi materiale
                    2) Aggiungi materiale pericoloso
                    3) Visualizza magazzino
                    4) Salva magazzino
                    5) Salva ed esci
                    """);
            System.out.print("\nScegli opzione: ");

            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome materiale: ");
                    String nome = sc.nextLine();
                    System.out.print("Inserisci quantità: ");
                    int quantita = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Inserisci prezzo unitario: ");
                    double prezzo = sc.nextDouble();
                    sc.nextLine();

                    gestioneMagazzino.aggiungiMateriale(nome, quantita, prezzo);
                    break;


                case 2:
                    System.out.print("Inserisci nome materiale: ");
                    String nome1 = sc.nextLine();
                    System.out.print("Inserisci quantità: ");
                    int quantita1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Inserisci prezzo unitario: ");
                    double prezzo1 = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Inserisci classe pericolo");
                    int classe = sc.nextInt();
                    sc.nextLine();

                    gestioneMagazzino.aggiungiMaterialePericoloso(nome1, quantita1, prezzo1, classe);
                    break;


                case 3:
                    gestioneMagazzino.visualizzaMagazzino();
                    break;


                case 4:
                    gestioneMagazzino.salvaMagazzino();
                    break;


                case 5:
                    gestioneMagazzino.salvaMagazzino();
                    System.out.println("Adioos");
                    break;


                default:
                    System.out.println("Opzione non valida, riprova");
            }


        } while (scelta != 5);

        sc.close();
    }
}
