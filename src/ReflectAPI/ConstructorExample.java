package ReflectAPI;
import java.lang.reflect.*;
public class ConstructorExample {
    public static void main(String[] args) {
        Constructor consob [] = B.class.getConstructors();
        Class [] p = { int.class , int.class};
        try{
            Constructor  cons = B.class.getConstructor(p);
            System.out.println(" Constructor object : "+ cons.getName() + " "+ cons.toGenericString());

        }
        catch(Exception e ){
            System.out.println("Exception caugth : "+ e.getMessage());
        }

        for ( int i =0; i < consob.length ; i++){
            // only visible constructor will be listed
            System.out.println(" Constructer object 1 :"+ consob[i].toGenericString());
        }
    }
}

