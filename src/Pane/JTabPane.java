package Pane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JTabPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame(" JTabbedpane and Box Layout Exmaple");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(setTabbedPane());
        frame.setVisible(true);
    }
    static JTabbedPane setTabbedPane( ){
        JTabbedPane jt = new JTabbedPane();
        jt.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        Box box = Box.createVerticalBox();
        box.add( Box.createVerticalGlue());
        JTextArea question = new JTextArea();
        question.setText("Which of the following options do you have installed?");
        question.setEditable(false);
        //question.setSize( new Dimension(300,20));
        question.setMaximumSize(new Dimension(300,50));
        question.setAlignmentX(0.0f);

        box.setSize(new Dimension(400,400));
        box.add(question);
        JCheckBox audio = new JCheckBox();
        audio.setAlignmentX(0.1f);
        audio.setText("Audio");
        question.setBackground( box.getBackground());
        JCheckBox video = new JCheckBox("Video");
        audio.setBackground( box.getBackground());
        video.setBackground( box.getBackground());
        video.setAlignmentX( 0.1f);
        JCheckBox ethernet = new JCheckBox("Ethernet Card");
        ethernet.setBackground( box.getBackground());
        box.add(audio);
        box.add(video);
        box.add(ethernet);
        box.add(Box.createVerticalGlue());
        jt.add("System",box);
        Box audioBox = Box.createVerticalBox();
        audioBox.add(Box.createVerticalGlue());
        JTextArea audioText= new JTextArea("This is audio Text.");
        audioBox.add(audioText);
        audioText.setEditable(false);
        audioBox.add(Box.createVerticalGlue());
        jt.add("Audio",audioBox);
        Box videoBox = Box.createVerticalBox();
        audioBox.add(Box.createVerticalGlue());
        JTextArea videoText= new JTextArea("This is audio Text.");
        videoBox.add(audioText);
        videoText.setEditable(false);
        videoBox.add(Box.createVerticalGlue());

        Box ethernetBox =Box.createVerticalBox();
        JTextArea ethernetText = new JTextArea("This is Ethernet Box");
        ethernetText.setEditable(false);
        ethernetBox.add(Box.createVerticalGlue());
        ethernetText.setMaximumSize(new Dimension(400,50));
        ethernetBox.add(ethernetText);
        ethernetBox.add(Box.createVerticalGlue());

        jt.add("Video",videoBox);
        jt.add("Ethernet", ethernetBox);
        ButtonGroup group = new ButtonGroup();
        group.add(audio);
        group.add(video);
        group.add(ethernet);
        TabManager listener = new TabManager();
        audio.addItemListener ( listener);
        video.addItemListener( listener);
        ethernet.addItemListener( listener);
        return jt;
    }
}

class TabManager implements ItemListener{
    public void itemStateChanged( ItemEvent e){
        JTabbedPane jt =  (JTabbedPane) ( (Box) ( (JCheckBox)e.getSource() ).getParent() ).getParent();
        JCheckBox c = (JCheckBox)e.getSource();
        System.out.println(c.getText());
        if ( (c.getText()).compareToIgnoreCase( "Audio")  ==  0 ) {
            jt.setEnabledAt(1, true);
            System.out.println("It should change tab now. ");
            jt.setSelectedIndex(1);
            jt.setSelectedIndex(1);
        }
        if ( c.getText() == "Video")
            jt.setEnabledAt(2,true);
        if ( c.getText() == "Ethernet");
            jt.setEnabledAt(3, true);
    }
}
