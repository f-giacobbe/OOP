package Miei.SerializationTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente("Francesco", "Giacobbe", 250000);
        Dipendente d2 = new Dipendente("Pinco", "Pallino", 20000);

        GestioneDipendenti gd = new GestioneDipendenti();
        gd.aggiungiDipendente(d1);
        gd.aggiungiDipendente(d2);
        gd.salvaDipendenti();
        d1.aggiungiOraLavorata();
        d1.aggiungiOraLavorata();
        d2.aggiungiOraLavorata();
        gd.stampaDipendenti();

        System.out.println();

        GestioneDipendenti gd2 = new GestioneDipendenti();
        gd2.stampaDipendenti();


        //azzero il file per la prossima esecuzione
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("Miei/SerializationTest/mieidipendenti.ser"));
            bw.write("");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
