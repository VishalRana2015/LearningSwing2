package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.*;
public class ScrollpaneExample {
    public static void main(String[] args) {

        JFrame frame = new JFrame("JScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50,0);
        //frame.setSize(500,500);
        JTextArea main = new JTextArea("This is the main viewport ");
        JTextArea row = new JTextArea("row");
        JTextArea col = new JTextArea("col");
        JScrollPane pane = new JScrollPane(main);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JViewport rowport = new JViewport();
        rowport.add(row);
        JViewport colport = new JViewport();
        colport.add(col);
        pane.setColumnHeader(colport);
        ImageIcon icon = new ImageIcon("C:\\Users\\RANA1947\\Desktop\\batman.jpg");
        pane.setRowHeader(rowport);
        System.out.println("Image Height : "+icon.getIconHeight());
        System.out.println("Image Width : "+icon.getIconWidth());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JViewport viewport = new JViewport();
        viewport.setSize(100,100);

        viewport.setLocation(0,0);
        panel.add(viewport,BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        JLabel label = new JLabel(icon);
        label.setSize(630,630);
        viewport.setPreferredSize(new Dimension(100,100));
        viewport.setMinimumSize(new Dimension(100,100));
        viewport.setMaximumSize(new Dimension(100,100));
        viewport.setSize(100,100);
        viewport.setView(label);
        viewport.add(label);
        viewport.setViewPosition(new Point(10,20));
        System.out.println(viewport.getExtentSize().getHeight());
        System.out.println(viewport.getViewSize().getHeight());
        panel.setSize(100,100);
        frame.setContentPane(panel);
        frame.setVisible(true);
        System.out.println(viewport.getSize().getHeight());
    }
}
