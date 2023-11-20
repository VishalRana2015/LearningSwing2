package ReflectAPI;
import java.util.*;
import java.lang.*;
import java.lang.Exception;
import java.io.Serializable;
import java.lang.reflect.*;
class AA{
    private int a;
    protected int b;
    public int c;
    AA(int a ){
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

class BB extends AA implements Serializable {
    public int d;
    protected int e;
    private int f;
    BB(int a, int b){
        super(a);
        this.d = b;
        e = b*2;
        f = b*3;
    }
    public int getb() throws ArithmeticException{
        return b;
    }
    public void setb(int b) throws ArithmeticException {
        this.b = b;
    }
    private class C{
    }
    static class D{

    }
}

public class MethodExample {
    public static void main(String[] args) {
        Class ins = B.class;
        Method method;
        try {
            Class[] p ={ int.class };
            method = ins.getMethod("setb",p );
        }
        catch(Exception e){
            System.out.println("Exception caught : "+e.getMessage());
            return ;

        }
        System.out.println("Modifiers : "+ Modifier.toString( method.getModifiers()));
        System.out.println(" Declaring class : "+ method.getDeclaringClass().getName());
        Class[] exp = (Class[]) method.getGenericExceptionTypes();

        for ( int i =0; i < exp.length; i++){
            System.out.println( "      "+exp[i].getName());
        }

        System.out.println();
        System.out.println(" Parameter count of setb() method of class B "+ method.getParameterCount());
        System.out.println("Listing parameter types : ");
        Class[] p = method.getParameterTypes();
        for ( int i =0; i < p.length; i++){
            System.out.println( "       "+ p[i].getName());
        }
        TypeVariable<Method> [] v = method.getTypeParameters();
        for ( int i =0; i < v.length; i++){
            System.out.println( "      " +v[i].getName());
        }
    }
}
