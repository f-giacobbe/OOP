package Lezione21;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
    public static Collection<String> inputToIPV4() {
        LinkedList<String> matches = new LinkedList<>();

        Pattern pattern = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\b");

        try (Scanner input = new Scanner(System.in)) {
            int i = 0;
            System.out.println("\nType 'exit' to stop the input stream. Please input ONE ipv4 address per line");
            while (true) {
                System.out.print("Line " + i + ":");
                String line = input.nextLine();

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    matches.add(matcher.group());
                }

                i++;
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        System.out.println(inputToIPV4());
    }
}
