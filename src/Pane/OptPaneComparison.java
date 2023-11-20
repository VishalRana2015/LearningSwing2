package Pane;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class OptPaneComparison {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("JOptionPane Constructor vs Static methods. ");
        frame.setSize(500,500);
        frame.setLocation( 50 , 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        JMenu construct = new JMenu("Constructor");
        JMenu stat = new JMenu( "Static");
        bar.add(construct);
        bar.add(stat);
        JMenuItem dconstruct = new JMenuItem("Dialog construct");
        JMenuItem iconstruct = new JMenuItem( "Internal Dialog Construct");
        JMenuItem dstat = new JMenuItem("static Dialog");
        JMenuItem istat = new JMenuItem( "static Internal Dialog");
        construct.add(dconstruct);
        construct.add(iconstruct);
        stat.add(dstat);
        stat.add(istat);
        JDesktopPane desk = new JDesktopPane();
        frame.setContentPane(desk);
        JInternalFrame frame1= new JInternalFrame("Internal Frame1");
        JInternalFrame frame2 = new JInternalFrame("Internal Frame2");
        frame1.setVisible(true);
        frame2.setVisible(true);
        desk.add(frame1);
        desk.add(frame2);
        dconstruct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" Action Performed");
            JOptionPane pane = new JOptionPane("Dialog using constructor ",JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
                Object [] selectionValues = new Object[ ] {"Red", "Green", "Blue", "Cyan"};
                Object initialValue ="Red";
                pane.setWantsInput(true);
                pane.setSelectionValues(selectionValues);
                pane.setInitialSelectionValue(initialValue);
                //pane.setOptions(selectionValues);
               // pane.setInitialValue("Red");

                pane.createDialog(desk,"Hello Brother").setVisible(true);
                System.out.println("Get Input Values : "+ pane.getInputValue());
                System.out.println("Get Values :  " + pane.getValue());

            }
        });
        frame.setJMenuBar( bar);
        frame.setVisible(true);
    }
    public static void respond(){

    }
}