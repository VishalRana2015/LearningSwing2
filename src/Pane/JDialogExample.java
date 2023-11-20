package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class JDialogExample {
    public static void main(String[] args) {
        JFrame frame  = new JFrame( "JDialog Example");
        frame.setSize( 500,500);
        frame.setLocation( 50, 0 );
        JButton button = new JButton ( "Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked.");
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout( new GridLayout(2,1));
        JButton showDialog = new JButton("Show Dialog");
        panel.add(button);
        panel.add(showDialog);
        showDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame,"Dialog Box",true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setSize(100,100);
                dialog.setLocation(100,100);
                dialog.setLocationRelativeTo(frame);
                
                dialog.setVisible(true);
            }
        });
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
