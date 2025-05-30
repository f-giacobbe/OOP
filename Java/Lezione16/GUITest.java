package Lezione16;

import javax.swing.*;
import java.awt.*;

public class GUITest {
    public static void main(String[] args) {
        JFrame f = new JFrame("Pippo");
        JToolBar toolBar = new JToolBar();
        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        toolBar.add(b1);
        toolBar.add(b2);

        JTextArea tarea = new JTextArea();
        tarea.setPreferredSize(new Dimension(300, 400));
        b1.addActionListener(e -> tarea.append("Hello, I'm b1\n"));   //LAMBDA
        b2.addActionListener(e -> tarea.append("Hello, I'm b2\n"));

        f.add(toolBar, BorderLayout.NORTH);
        f.add(new JScrollPane(tarea), BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocation(new Point(700, 150));
        f.setVisible(true);
    }
}
