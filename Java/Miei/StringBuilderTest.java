package Miei;

import java.util.Scanner;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String prompt = "Inserisci stringa o carattere (digita stop per fermarti):";

        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(prompt);
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("stop")) {
                break;
            }

            if (userInput.equalsIgnoreCase("\\stop")) {
                userInput = userInput.replace("\\", "");
            }

            sb.append(userInput);
        } while (true);

        sc.close();

        System.out.println("La tua stringa completa è " + sb);
    }
}
