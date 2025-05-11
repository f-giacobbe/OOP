package Simulazione2;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfacciaUtente {
    private Soldi portafoglio;
    private final static String FILEPATH = "Simulazione2/money.txt";

    public InterfacciaUtente() {
        caricaSoldi();
    }

    private void caricaSoldi() {
        portafoglio = new SoldiList();
        boolean errori = false;

        Pattern p = Pattern.compile("(\\d+)#(\\D+)\\$");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILEPATH));

            String line = br.readLine();
            while (line != null) {
                Matcher m = p.matcher(line);

                if (m.find()) {
                    String pezziString = m.group(1);
                    String taglioString = m.group(2);

                    int pezzi = Integer.parseInt(pezziString);
                    Taglio t = Taglio.valueOf(taglioString);

                    DenaroConcreto den = new DenaroConcreto(t, pezzi);
                    portafoglio.add(den);
                } else {
                    errori = true;
                }

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("File non trovato o errore riscontrato. Inizializzo nuovo portafoglio");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        if (errori) {
            System.err.println("Attenzione! Sono stati riscontrati errori nella lettura e alcuni oggetti Denaro potrebbero non essere stati caricati. Controllare il file " + FILEPATH);
        }
    }

    private void caricaSoldi2() {
        portafoglio = new SoldiList();
        boolean errori = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))){
            String line = br.readLine();
            while (line != null) {
                try {
                    String[] splitLine = line.split("#");

                    String pezziString = splitLine[0];
                    String taglioString = splitLine[1].replace("$", "");

                    int pezzi = Integer.parseInt(pezziString);
                    Taglio taglio = Taglio.valueOf(taglioString);

                    portafoglio.add(new DenaroConcreto(taglio, pezzi));

                } catch (ArrayIndexOutOfBoundsException e) {
                    errori = true;
                } finally {
                    line = br.readLine();
                }

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        if (errori) {
            System.err.println("Attenzione! Sono stati riscontrati errori nella lettura e alcuni oggetti Denaro potrebbero non essere stati caricati. Controllare il file " + FILEPATH);
        }
    }

    private void salvaSoldi() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH))){
            for (Denaro d : portafoglio) {
                bw.write(d.getQuantita() + "#" + d.getTaglio() + "$\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void stampaPortafoglio() {
        for (Denaro d : portafoglio) {
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        InterfacciaUtente ux = new InterfacciaUtente();

        String prompt = """
                Benvenuto nella gestione denaro!
                
                1) Paga
                2) Deposita
                3) Preleva
                4) Stampa portafoglio
                5) Salva ed esci
                """;

        Scanner sc = new Scanner(System.in);

        int scelta;
        do {
            System.out.println(prompt);
            scelta = sc.nextInt();

            switch (scelta) {
                case 1:
                    //pagamento...
                    break;
                case 2:
                    //deposito...
                    break;
                case 3:
                    //prelievo...
                    break;
                case 4:
                    ux.stampaPortafoglio();
                    break;
                case 5:
                    ux.salvaSoldi();
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova");
            }
        } while (scelta != 5);

        sc.close();
    }
}
