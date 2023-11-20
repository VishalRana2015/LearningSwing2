package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class OverlayLayoutExmaple {
    public static void main(String[] args) {
        JFrame frame = new JFrame( " Overlay Layout Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("B1");
        JLabel label2 = new JLabel("B2");
        JLabel label3 = new JLabel( "B3");
        label1.setMinimumSize ( new Dimension(60,50));
        label2.setMinimumSize(new Dimension(80,40));
        label3.setMinimumSize(new Dimension(100,60));

        label1.setMaximumSize ( new Dimension(60,50));
        label2.setMaximumSize(new Dimension(80,40));
        label3.setMaximumSize(new Dimension(100,60));

        label1.setPreferredSize ( new Dimension(60,50));
        label2.setPreferredSize(new Dimension(80,40));
        label3.setPreferredSize(new Dimension(100,60));

        JPanel panel = new JPanel();
        OverlayLayout layout  = new OverlayLayout(panel);
        panel.setLayout(layout);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        frame.setContentPane(panel);
        panel.setMaximumSize(new Dimension(100,100));
        panel.setMinimumSize(new Dimension( 100,100));
        panel.setPreferredSize(new Dimension(100,100));
        label1.setAlignmentX(0.0f);
        label1.setAlignmentY(1.0f);
        label2.setAlignmentX(0.5f);
        label2.setAlignmentY(0.4f);
        label3.setAlignmentX(1.0f);
        label3.setAlignmentY(0.0f);
        label1.setBorder( BorderFactory.createLineBorder(Color.GREEN));
        label2.setBorder( BorderFactory.createLineBorder(Color.CYAN));
        label3.setBorder ( BorderFactory.createLineBorder( Color.RED));
        frame.setVisible(true);
    }
}
