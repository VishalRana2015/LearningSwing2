package Serialize;
import javax.management.remote.rmi._RMIConnection_Stub;
import java.io.*;
class test implements Serializable{
    int a;
    test(){
        System.out.println("Default Constructor called");
    }
    test ( int a){
        System.out.println("Parametrized constructor called");
        this.a = a;
    }
    private void readObject ( ObjectInputStream input) throws IOException{
        try{
            input.defaultReadObject();
            System.out.println("private Readobject method called of test class by the stream ");
        }
        catch(ClassNotFoundException e){
            System.out.println("Exception caught : "+e.getMessage());
        }
    }
    private void writeObject ( ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Object's wirteObject method called by the stream ");
    }

    public int geta(){
        return a;
    }

}
public class s1 {
    public static void main(String[] args) throws Exception{
        if ( args.length == 0){
            System.out.println("Syantax : s1 <save|restore>");
            return ;
        }

        File file = new File("C:\\Users\\RANA1947\\IdeaProjects\\Swing2\\src\\Serialize\\log.txt");

        if ( args[0].equals("save")){
            System.out.println("Saving ...");
            try{
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                test t = new test(20);
                oos.writeObject(t);
                System.out.println("saved");
            }
            catch(IOException e){
                System.out.println("IOException caught : "+e.getMessage());
            }
            catch(Exception e){
                System.out.println("Exception caught :"+e.getMessage());
            }
        }
        if ( args[0].equals("restore")){
            System.out.println("Restoring ...");
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                test tt = (test)ois.readObject();
                System.out.println("tt.a = "+tt.geta());
                System.out.println("Restored");
            }
            catch(IOException e ){
                System.out.println("Exception caught : "+e.getMessage());
            }
            catch(ClassNotFoundException e) {
                System.out.println("Exception caught : "+e.getMessage());
            }
        }
    }
}
