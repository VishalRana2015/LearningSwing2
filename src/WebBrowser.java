import java.io.*;
import java.util.*;

public class WebBrowser {
    public static void main(String[] args){
        try{
            List list = new ArrayList();
            list.add("tasklist ");
            Process p = Runtime.getRuntime().exec("tasklist");
            InputStream input = p.getInputStream();
            Scanner sc= new Scanner(input);
            String ss;

            while ( sc.hasNextLine() ){
                System.out.println( sc.nextLine());
            }

        }
        catch( Exception e){
            System.out.println("Exception caught : "+ e.getMessage());
        }
    }
}