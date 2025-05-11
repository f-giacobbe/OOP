package Lezione21;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        //riconosce ipv4
        Pattern pattern = Pattern.compile("(\\b\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\b");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();
                /*
                IMPORTANTE: è possibile passare come parametro a group il numero di gruppo che si vuole mat-
                chare (ad esempio se 192.168.1.1 è l'input, 192 sarà group 1, 168 group 2 ecc.)
                 */
                System.out.println(matcher.start() + ":" + matcher.end() + "[" + match + "]");
            }
        }

        //sc.close();   devo commentare altrimenti chiudo System.in e non mi funziona il secondo







        //prova per simulazione con pezzi#taglio$
        Pattern money = Pattern.compile("(\\d+)#(\\D+)\\$");
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.print("Digita linea:");
                String line = input.nextLine();

                //verifica chiusura
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                Matcher lineMatcher = money.matcher(line);
                while (lineMatcher.find()) {
                    String pezzi = lineMatcher.group(1);
                    String taglio = lineMatcher.group(2);
                    System.out.println("Pezzi: " + pezzi + "; Taglio: " + taglio);
                }

            }
        }
    }
}
