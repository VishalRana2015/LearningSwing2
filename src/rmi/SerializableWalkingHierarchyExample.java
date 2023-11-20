package rmi;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;
import java.util.*;
import java.awt.event.*;
import java.lang.reflect.*;
public class SerializableWalkingHierarchyExample {
    int serialversionUID = 1;
    public static void main(String[] args){
        Button button1  = new Button("Button1");
        Button button2= new Button("Button2");
        Button button3= new Button( "Button3");
        JFrame frame= new JFrame( "SerializableWalkingHierarchyExample");
        frame.setSize(500,500);
        frame.setLocation(50,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ListeningPanel panel = new ListeningPanel();
        try {
            File file = new File("C:\\Users\\RANA1947\\IdeaProjects\\Swing2\\src\\rmi\\log.txt");
            System.out.println("File created ");
            FileOutputStream fstream = new FileOutputStream(file);
            System.out.println("FileOutputStream has been created ");
            ObjectOutputStream ostream = new ObjectOutputStream(fstream);
            System.out.println("Object Output Stream has been created succcessfully");
            ostream.writeObject(panel);
            File fiile =new File("C:\\Users\\RANA1947\\rmi\\serialize\\log.txt");
        }

        catch(Exception e){
            System.out.println("Exception Caught : "+e.getMessage());
        }
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}

class ListeningPanel extends Panel implements Serializable{
    ListeningPanel(){
        super();
        Button button1= new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        this.add(button1);
        this.add(button2);
        this.add(button3);
        GenericButtonAdapter adapter = new GenericButtonAdapter();
        adapter.registerEventHandler(button1,"handle1");
        adapter.registerEventHandler(button2, "handle2");
        adapter.registerEventHandler(button3,"handle3");
        button1.addActionListener(adapter);
        button2.addActionListener( adapter);
        button3.addActionListener( adapter);

    }
}
class GenericButtonAdapter implements ActionListener{
    Hashtable mappingtable ;
    GenericButtonAdapter(){
        mappingtable = new Hashtable();
    }


    public void handle1( ActionEvent e){
        System.out.println("Handle 1 executed by the source : "+ e.getSource());

    }


    public void handle2 (  ActionEvent e){
        System.out.println("Handle2 Executed by the source :"+ e.getSource());

    }

    public void handle3 ( ActionEvent e){
        System.out.println("Handle3 executed by the source : "+e.getSource());
    }


    @Override
    public void actionPerformed ( ActionEvent e){
        Object source = e.getSource();
        try{
            if ( mappingtable.containsKey(source)){

                Method method = (Method)mappingtable.get(source);

                method.invoke(this,e);

            }
        }
        catch(Exception exp){
            System.out.println("Exception caught : "+exp.getMessage());
        }
    }

    public void list( ) {
            Enumeration e = mappingtable.elements();
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement().toString());
            }
        }


        public void registerEventHandler ( Button source , String methodName){
        Class cl = this.getClass();
        try{
            Class[] params = {ActionEvent.class};
            Method method = cl.getMethod(methodName , params);
            mappingtable.put(source, method);
        }
        catch( Exception e){
            System.out.println("Exception caught : "+ e.getMessage());
        }
    }


    public void unregisterEventHandler( Button source){
        if ( mappingtable.contains(source)){
            mappingtable.remove(source);
        }
    }

}