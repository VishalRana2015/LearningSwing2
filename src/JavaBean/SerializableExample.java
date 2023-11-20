package JavaBean;

import javax.swing.event.*;
import javax.swing.*;
import java.io.Serializable;
import java.io.*;
class A implements Serializable{
    protected int i;
    private void writeObject ( ObjectOutputStream stream) throws java.io.IOException{
        System.out.println("WriteObject called for Class A");
        stream.defaultWriteObject();
    }
    private void readObject ( ObjectInputStream stream) throws java.io.IOException{
        System.out.println("ReadObject called for class B");
        try{
            stream.defaultReadObject();
        }
        catch( Exception e){
            System.out.println("Exception thrown in Class A : "+e.getMessage());
        }
    }
}

class B extends A{
    int b;
    private void writeObject ( ObjectOutputStream stream) throws java.io.IOException{
        System.out.println("WriteObject called for class B ");
        stream.defaultWriteObject();
    }
    private void readObject ( ObjectInputStream stream) throws java.io.IOException {
        System.out.println("ReadObject called for class A");
        try{
            stream.defaultReadObject();
        }
        catch(Exception e){
            System.out.println("Exception thrown in class B : "+e.getMessage());
        }
    }
}
class C extends B{
    int c;
    private void writeObject ( ObjectOutputStream stream) throws java.io.IOException {
        System.out.println("WriteObject called for class C");
        stream.defaultWriteObject();
    }
    private void readObject( ObjectInputStream stream) throws java.io.IOException{
        System.out.println("ReadObject called for Class C");
        try{
            stream.defaultReadObject();
        }
        catch( Exception e){
            System.out.println( " Exception throw in class C " +e.getMessage());
        }
    }
}


public class SerializableExample{
    public static void main(String[] args) throws Exception{
        C c = new C();
        Byte[] b = new Byte[10];
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream(50);
        ObjectOutputStream s = new ObjectOutputStream(bytestream);
        s.writeObject(c);

    }
}