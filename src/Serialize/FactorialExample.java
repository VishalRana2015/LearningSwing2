package Serialize;

import java.io.*;


class Factorial implements Serializable , ObjectInputValidation {
    int f;
    long fact;
    final static long serialVersionUID = 1L;
    Factorial(){
        f =0;
    }
    Factorial( int f){
        this.f = f;
        this.fact = computeFact();
    }
    public int getf(){
        return f;
    }
    public void setf(int f){
        this.f = f;
        fact = computeFact();
    }
    public long getFact(){
        return fact;
    }
    private long computeFact ( ) {
        long temp = 1;
        for (int i = 1; i <= f; i++) {
            temp = temp*i;
        }
        return temp;
    }
    private void readObject ( ObjectInputStream input) throws IOException,ClassNotFoundException {
        System.out.println("Object InputStream readObject method called this.f "+ this.f+"this.fact "+ this.fact);
        input.defaultReadObject();
        System.out.println("defaultReadObject method called this.f = "+this.f+ "this.fact = "+this.fact);
        input.registerValidation(this,0);
        System.out.println("Registervalidation called this.f ="+this.f+"this.fact= "+this.fact);

    }

    @Override
    public void validateObject() throws InvalidObjectException {
        System.out.println("validate object called ");
        System.out.println("Before value of fact : "+ this.fact);
        fact = computeFact();
        System.out.println("After value of fact : "+ this.fact);
        System.out.println("Getting out of validate object ");
    }
}

/*
class Factorial implements Serializable {
    int f;
    public static final long serialVersionUID = 1L;
    Factorial(){
         f= 0;
    }

    Factorial(int f){
        this.f = f;
    }

    public int getf(){
        return f;

    }
    public void setf(int f){
        this.f = f;
    }
    public long getFact(){
        return computeFact();
    }
    public long computeFact( ){
        long temp =1;
        for ( int i =1; i <=f ; i++)
            temp = temp*i;
        return temp;
    }
}

*/
public class FactorialExample {
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
                Factorial ob = new Factorial(5);
                oos.writeObject(ob);
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
                Factorial ob = (Factorial)ois.readObject();
                System.out.println("ob.f = "+ob.getf()+"ob.Fact = "+ob.getFact());
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
