package Esercitazione4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String prompt = """
                Seleziona:
                    1) leggi report
                    2) leggi lettera
                    3) scrivi report
                    4) scrivi lettera
                oppure digita un valore negativo (es. -1) per terminare il programma
                """;

        int n = 0;

        while (n >= 0) {
            System.out.println(prompt);
            n = input.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Report");
                    break;

                case 2:
                    System.out.println("Lettera");
                    break;

                case 3:
                    //report
                    input.nextLine();
                    System.out.println("Scrivi il testo: ");
                    String testo = input.nextLine();

                    System.out.println("Nome proprietario: ");
                    String proprietario = input.nextLine();

                    System.out.println("Firma: ");
                    String firma = input.nextLine();

                    System.out.println("Destinatario: ");
                    String destinatario = input.nextLine();

                    System.out.println("Quanti parametri nel report? ");
                    int quantiParametri = input.nextInt();
                    input.nextLine();
                    String[] parametri = new String[quantiParametri];
                    boolean[] parametriRaggiunti = new boolean[quantiParametri];
                    for (int i = 0; i < quantiParametri; i++) {
                        System.out.println("Inserisci parametro numero " + i);
                        parametri[i] = input.nextLine();
                        System.out.println("è stato raggiunto? (true o false)");
                        parametriRaggiunti[i] = input.nextBoolean();
                        input.nextLine();
                    }

                    Report r = new Report(testo, proprietario, firma, destinatario, parametri, parametriRaggiunti);

                    System.out.println("Report creato!");
                    break;


                case 4:
                    //lettera
                    input.nextLine();
                    System.out.println("Scrivi il testo: ");
                    testo = input.nextLine();

                    System.out.println("Nome proprietario: ");
                    proprietario = input.nextLine();

                    System.out.println("Firma: ");
                    firma = input.nextLine();

                    System.out.println("Mittente: ");
                    String mittente = input.nextLine();

                    System.out.println("Destinatario: ");
                    destinatario = input.nextLine();

                    Lettera l = new Lettera(testo, proprietario, firma, mittente, destinatario);
                    System.out.println("Lettera creata!");
                    break;
            }
        }
    }
}
