package Esercitazione7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    //abstract window toolkit

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Esempio di GUI");
        JPanel panel = new JPanel();
        JButton button = new JButton("Cliccami!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Hai cliccato!");
            }
        });

        panel.add(button);
        frame.add(panel);

        //mio
        JButton exit = new JButton("Termina programma");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exit);
        //

        panel.setLayout(new GridLayout(2,2));

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
