package ReflectAPI;
import java.io.Serializable;
import java.lang.reflect.*;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.util.*;

class A{
    private int a;
    protected int b;
    public int c;
    A(int a ){
        this.a = a;
        b = a*2;
        c = a*3;
    }
    public int geta(){
        return a;

    }
    public void seta( int a ){
        this.a= a;
    }
}

class B extends A implements Serializable{
    public int d;
    protected int e;
    private int f;
    public B(int a, int b){
        super(a);
        this.d = b;
        e = b*2;
        f = b*3;
    }
    public int getb(){
        return b;
    }
    public void setb(int b){
        this.b = b;
    }
   private class C{
    }
    static class D{

    }
}

// This class demonstrate all methods of class 'Class'
public class ClassExample {
    public static void main(String[] args) {
        B obj = new B(2,3);
        Class ins = obj.getClass();
        System.out.println("Is B is local class : "+ins.isLocalClass());
        System.out.println( " is obj is assignable from Class B "+ ins.isInstance(obj));
        System.out.println("Name of the Class : "+ins.getName());
        Class javaclass  = Vector.class;

        System.out.println(" Vector class Name : "+ javaclass.getName());
        System.out.println("Vector Canonical Name : "+javaclass.getCanonicalName());
        System.out.println("Vector Simple Name :"+javaclass.getSimpleName());
        System.out.println("Vector Type Name : "+ javaclass.getTypeName());
        try{
            System.out.println("Creating new class of class B :"+ins.newInstance());
        }
        catch(Exception e){
            System.out.println("Excetion occurred while instantiating object of class B using newInstance(): "+ e.getMessage());
        }
        System.out.println("Is class B interface :"+ ins.isInterface());
        try {
            System.out.println(" Is Remote interface : " + Class.forName("java.rmi.Remote").isInterface());
        }
        catch(Exception e){
            System.out.println("Exception caught for rmi : "+ e.getMessage());
        }
        int [] array =  {2,3};
        System.out.println(" is 'array' array :  "+ array.getClass().isArray());
        System.out.println(" is B array : "+ ins.isArray());
        System.out.println(" is int[] primitive : "+ int[].class.isPrimitive());
        System.out.println(" is float primitive : "+ int.class.isPrimitive());
        System.out.println( " is Float primitive : "+ Float.class.isPrimitive());
        System.out.println(" SuperClass of B : "+ ins.getSuperclass().toString());
        Field [] fieldob = ins.getFields();
        System.out.println("Demonstrating Field() method : ");
        for ( int i =0; i < fieldob.length; i++){
            System.out.println("     "+ fieldob[i].toString());
        }

        System.out.println("");
        System.out.println("Demonstrating GetDeclaredFields())");
        fieldob = ins.getDeclaredFields();
        for ( int i =0; i < fieldob.length; i++){
            System.out.println(" "+ fieldob[i].toGenericString());
        }
        System.out.println("");
        Method[] methodob = ins.getMethods();
        System.out.println("Demostrating getMethods() ");
        for ( int i =0; i < methodob.length; i++){
            System.out.println("       "+ methodob[i].toGenericString());
        }
        System.out.println();
        System.out.println("Demonstrating getDeclaredMethods ");
        methodob = ins.getDeclaredMethods();
        for ( int i =0; i < methodob.length; i++){
            System.out.println( "      "+ methodob[i].toGenericString());
        }

        System.out.println("Demonstrating getConstructor : ");
        Constructor [] consob = ins.getConstructors();
        for ( int i =0; i < consob.length; i++){
            System.out.println("      " + consob[i].toString());
            System.out.print(" and its Generic name : "+ consob[i].toGenericString());
        }
        System.out.println();

        System.out.println("Demonstrating getInerface() method : ");
        System.out.println(ins.getInterfaces().toString());
        System.out.println();

        System.out.println("Demostrating getModifiers for class B");
        System.out.println( Modifier.toString( ins.getModifiers()));

        Package pac = ins.getPackage();
        System.out.println(" Package of class B :"+ ins.getPackage().toString());
        System.out.println();

        ProtectionDomain pob = ins.getProtectionDomain();
        System.out.println("Demonstrating protection domain ClassLoader: "+ pob.getClassLoader());
        PermissionCollection per = pob.getPermissions();
        System.out.println( per.elements().toString());

        System.out.println();

        System.out.println("ins.getDeclaringClass() : "+ins.getDeclaredClasses());
        System.out.println("ins.getEnclosingClass() : "+ins.getEnclosingClass());
        Class[] decclassesob = ins.getDeclaredClasses();
        for ( int i =0; i < decclassesob.length; i++){
            System.out.println("      Name : "+ decclassesob[i].getName());
            System.out.println("       CanonicalName : "+ decclassesob[i].getCanonicalName());
            System.out.println( "       Type Name : " + decclassesob[i].getTypeName());
            System.out.println(  "      Enclosing Class : " + decclassesob[i].getEnclosingClass().getName());
            System.out.println();
        }

        System.out.println();

        }

}
