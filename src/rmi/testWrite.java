package rmi;
import java.io.*;
class test{
    int a, b;
    test( ){
        this.a = a;
        this.b= b;
    }
    test( int a, int b){
        this.a = a;
        this.b= b;
    }
    public int geta(){
        return a;
    }
    public int getb(){
        return b;
    }
    public void seta(int a){
        this.a =a;
    }
    public void setb( int b){
        this.b = b;
    }
}

public class testWrite{
    public static void main(String[] args) {
        test obj = new test(2, 3);
        File file = new File("C:\\Users\\RANA1947\\rmi\\log.txt");

    }
}