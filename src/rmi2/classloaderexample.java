package rmi2;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLClassLoader;

public class classloaderexample {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls =  ( (URLClassLoader ) cl).getURLs();
        for ( URL url : urls){
            System.out.println( url.getFile());
        }
        System.out.println(cl.toString() + "parent is : "+cl.getParent().toString());

        ClassLoader clp = cl.getParent();
        urls =  ( (URLClassLoader) cl).getURLs();
        System.out.println();
        System.out.println();
        for ( URL url : urls){
            System.out.println( url);
        }

        System.out.println(clp.toString() + " parent is : "+clp.getParent());

        ClassLoader clpp = clp.getParent();
        System.out.println();
        System.out.println();
        URLClassLoader ul = (URLClassLoader )cl;
        System.out.println("Get Resource : "+ul.getResource("rt.jar"));
    }
}
