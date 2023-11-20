package Pane;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
public class SplitPaneExample {
    public static void main( String [] args){
        JFrame frame = new JFrame("This is the example");
        String s = "This is the simple example of split pane that is used as a divider and can be understood easily as " +
                " as a metaphor for news column in newspaper.";
        JTextArea j1 = new JTextArea(s);
        JTextArea j2 = new JTextArea(s);
        j1.setLineWrap(true);
        j2.setLineWrap(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(50,0);
        frame.setSize(500,500);
        j1.setMinimumSize(new Dimension(50,50));
        j2.setMinimumSize(new Dimension(200,200));
        JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,j1,j2);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(splitpane,BorderLayout.CENTER);
        splitpane.setOneTouchExpandable(true);
        System.out.println(splitpane.getLeftComponent());
        System.out.println(splitpane.getResizeWeight());

        splitpane.setResizeWeight(0.5);
        splitpane.setContinuousLayout(true);
        splitpane.setDividerLocation(0.5);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}
