package Caret;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
public class CaretExample {
    public static void main(String[] args) {
        JFrame frame= new JFrame("Caret Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea area = new JTextArea(10,10);
        area.setMinimumSize(new Dimension(100,100));
        area.setPreferredSize(new Dimension(100,100));
        area.setMaximumSize(new Dimension(100,100));
        area.setLineWrap(true);
        DefaultCaret caret = (DefaultCaret)area.getCaret();
        caret.setSize(40,40);
        area.setCaretColor( Color.GREEN);

        frame.setContentPane(area);
        frame.setVisible(true);
    }
}
