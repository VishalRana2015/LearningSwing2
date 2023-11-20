package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class JOptionPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("JOptionPane Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Show JoptionPane");
        JButton showinputdialog = new JButton("Show Input Dialog");
        showinputdialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = JOptionPane.showInputDialog("Enter Your name","This is initial selection value");
                System.out.println(o.toString());
            }
        });
        button.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                        int i = JOptionPane.showConfirmDialog(frame,"This is a confim diaglog","Confirm Dialog",JOptionPane.WARNING_MESSAGE);
                                        System.out.println(" i = "+i);
                                     }
                                 }
        );
        JButton internalconfirmdialog = new JButton("Show Internal Confirm Dialog");
        internalconfirmdialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane pane = new JOptionPane();
                JList list = new JList();
                list.add("Button 1 ", new JButton("button 1 "));
                list.add( "Button 2", new JButton("button 2"));
                list.add( "Button 3 ", new JButton ( " button 3"));
                pane.setMessage(list);
                pane.setMessageType(JOptionPane.OK_CANCEL_OPTION);
                pane.createDialog("Dialog");

                //System.out.println(o.toString());
            }
        });
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(button);
        box.add(Box.createVerticalStrut(2));
        box.add(Box.createVerticalGlue());
        box.add(showinputdialog);

        box.add(Box.createVerticalStrut(5));
        box.add(Box.createVerticalGlue());
        box.add(internalconfirmdialog);
        box.add(Box.createVerticalGlue());
        frame.setContentPane(box);
        frame.setVisible(true);


    }
}
