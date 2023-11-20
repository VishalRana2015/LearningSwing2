package Pane;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TabbedPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame ("JTabbedPane Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jt = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
        jt.addTab("Tab for Label1", new JLabel("This is Label 1 Tab."));
        jt.addTab("Tab for Label2", new JLabel("This is Label2 Tab."));
        jt.addTab("Tab for Label3", new JLabel("This is Label 3 Tab."));
        jt.setBackgroundAt(2,Color.RED);
        System.out.println(jt.getBoundsAt(2));
        jt.setForegroundAt(2,Color.GREEN);
        System.out.println("Tab Cound : "+jt.getTabCount());
        jt.setMnemonicAt(2,'L');
        ImageIcon icon = new ImageIcon("C:\\Users\\RANA1947\\IdeaProjects\\Swing2\\Images\\tabIcon.jpg");
        System.out.println("Enabled at : "+jt.isEnabledAt(2));
        jt.setEnabledAt(2,false);
        jt.setIconAt(2,icon);
        jt.setToolTipTextAt(0,"This is tab 1");
        System.out.println(jt.getBackgroundAt(2));
        frame.setContentPane(jt);
        System.out.println("Tab Run Count : "+jt.getTabRunCount());
        frame.setVisible(true);

    }
}
