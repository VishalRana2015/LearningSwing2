package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPane2Example {
    static JFrame frame;
    public static void main(String[] args) {
        frame =new JFrame("JOtionPane using construtor ");
        frame.setSize(500,500);
        frame.setLocation( 50 , 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton ( "Show Option Pane");
        frame.setContentPane(button);
        button.addActionListener( new Listener());
        frame.setVisible(true);
    }
}

class Listener implements ActionListener{
    public void actionPerformed( ActionEvent e){
       Object[] options = new Object[] { new JLabel("Red") , new JLabel("Green") , "Blue" , "Cyan"};
       Object initialoption = "Red";
       ImageIcon icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\Swing2\\Images\\dialogbox.jpg");
       JOptionPane.showOptionDialog(JOptionPane2Example.frame,"Select any Button","Selection Dialog",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,icon,options,initialoption);

       JOptionPane.showInputDialog(JOptionPane2Example.frame,"Select any one color","Input Dialog",JOptionPane.QUESTION_MESSAGE,icon,options,initialoption);
        JOptionPane.showInternalConfirmDialog(JOptionPane2Example.frame.getContentPane(),"Select any color","Internal Confirm Dialog",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,icon);

    }
}
