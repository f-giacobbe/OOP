package Miei;

import java.util.Scanner;

public class SwitchCaseEnumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String giorno = sc.nextLine();

        switch (giorno) {
            case "lunedì" -> System.out.println(1);
            case "martedì" -> System.out.println(2);
            default -> System.out.println(0);
        }

        System.out.println(switch(sc.nextLine()) {
            case "lunedì" -> 1;
            case "martedì" -> 2;
            default -> "0";
        });

        System.out.println(giornoSwitch(sc.nextLine()));
    }

    public static int giornoSwitch(String giorno) {
        return switch (giorno) {
            case "lunedì" -> 1;
            case "martedì" -> 2;
            default -> 0;
        };
    }
}
