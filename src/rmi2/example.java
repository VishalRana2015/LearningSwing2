package rmi2;
import com.sun.javafx.runtime.SystemProperties;



import java.lang.annotation.Annotation;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Enumeration;
import java.util.Properties;
import static com.sun.javafx.runtime.SystemProperties.codebase;

public class example {
    public static void main(String[] args) {
        System.out.println(com.sun.javafx.runtime.SystemProperties.getCodebase());
        System.out.println(com.sun.javafx.runtime.SystemProperties.codebase);
        System.out.println(SystemProperties.getProperty("java.home"));
        Properties p = System.getProperties();
        Enumeration e= p.propertyNames();
        example eee = new example();
        Annotation[] an = eee.getClass().getAnnotations();

    }
}
