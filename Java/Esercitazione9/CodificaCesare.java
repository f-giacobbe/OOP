package Esercitazione9;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class CodificaCesare {
    public static void codificaCesare(String[] params) {
        //controllo degli argomenti da linea di comando
        if (params.length != 4) {
            System.out.println("Uso: java CodificaCesare <-e|-d> <file_input> <file_output> <shift>");
            return;
        }


        //lettura flags e file
        String mode = params[0];          //encode o decode
        String inputFilePath = params[1];
        String outputFilePath = params[2];
        int shift = Integer.parseInt(params[3]);     //spostamento fisso per la codifica di Cesare


        //verifica della modalità (codifica o decodifica)
        if ("-e".equals(mode)) {
            System.out.println("Modalità: cifratura");
        } else if ("-d".equals(mode)) {
            System.out.println("Modalità: decifratura");
            shift = -shift;     //inverto lo spostamento per decifrare
        } else {
            System.err.println("Errore! Usa -e per cifrare e -d per decifrare");
            return;
        }


        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //legge il contenuto dei file di input e output
            br = new BufferedReader(new FileReader(inputFilePath));
            bw = new BufferedWriter(new FileWriter(outputFilePath));

            //applica la codifica o la decodifica di Cesare
            String s = br.readLine();
            while (s != null) {
                String processedContent = cesareTransform(s, shift);

                //scrive il testo elaborato il un nuovo file
                bw.write(processedContent);
                bw.newLine();
                s = br.readLine();
            }
            System.out.println("Operazione completata! File salvato in: " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Errore durante la lettura o scrittura del file. " + e.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }

            } catch (IOException e) {
                System.err.println("Errore nella chiusura. " + e.getMessage());
            }

            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException e) {
                System.err.println("Errore nella chiusura " + e.getMessage());
            }
        }
    }



    //metodo che attua la cifrazione di Cesare
    private static String cesareTransform(String text, int shift) {
        StringBuilder transformed = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                transformed.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                //i caratteri non alfabetici rimangono invariati
                transformed.append(c);
            }
        }

        return transformed.toString();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Caesar cipher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLayout(new FlowLayout());
        frame.setLocation(250, 100);


        JPanel first = new JPanel();
        first.setLayout(new FlowLayout());
        JPanel second = new JPanel();
        second.setLayout(new FlowLayout());
        JPanel third = new JPanel();
        third.setLayout(new FlowLayout());
        JPanel fourth = new JPanel();
        fourth.setLayout(new FlowLayout());


        JLabel label1 = new JLabel("Seleziona file di input");
        JTextField textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100, 20));
        JButton button1 = new JButton("browse");

        JLabel label2 = new JLabel("Seleziona file di output");
        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100, 20));
        JButton button2 = new JButton("browse");

        JLabel label3 = new JLabel("Inserisci shift");
        JTextField textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(50, 20));

        JButton cipherButton = new JButton("Cipher");
        JButton decipherButton = new JButton("Decipher");


        //aggiunta dei componenti al frame
        first.add(label1);
        first.add(textField1);
        first.add(button1);
        second.add(label2);
        second.add(textField2);
        second.add(button2);
        third.add(label3);
        third.add(textField3);
        fourth.add(cipherButton);
        fourth.add(decipherButton);


        //browse button 1
        button1.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int res = fileChooser.showOpenDialog(frame);

            if (res == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textField1.setText(selectedFile.getAbsolutePath());
            }
        });

        //browse button 2
        button2.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int res = fileChooser.showOpenDialog(frame);

            if (res == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                textField2.setText(selectedFile.getAbsolutePath());
            }
        });

        //cipher button
        cipherButton.addActionListener(e -> {
            codificaCesare(new String[]{"-e", textField1.getText(), textField2.getText(), textField3.getText()});
        });

        //decipher button
        decipherButton.addActionListener(e -> {
            codificaCesare(new String[]{"-d", textField1.getText(), textField2.getText(), textField3.getText()});
        });


        frame.add(first);
        frame.add(second);
        frame.add(third);
        frame.add(fourth);
        frame.setVisible(true);
    }
}
