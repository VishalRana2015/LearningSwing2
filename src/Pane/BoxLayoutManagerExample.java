package Pane;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class BoxLayoutManagerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Box Class Example");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box box = new Box(BoxLayout.X_AXIS);
        for (int i =0; i < 3 ; i++){
            box.add(Box.createHorizontalGlue());
            box.add(new JButton("Button"+i));
        }

        frame.setContentPane(box);
        box.add( Box.createVerticalGlue());
        System.out.println("Component Count : "+box.getComponentCount());
        frame.setVisible(true);
    }
}
