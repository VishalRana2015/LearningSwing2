package rmi;
import java.io.File;
import java.rmi.*;
import java.lang.*;
import java.rmi.server.*;
/*

interface Adder extends Remote{
    int add( int a, int b) throws RemoteException ;
}

class Adder1 extends UnicastRemoteObject implements Client.Adder {
    public int add ( int a, int b) throws RemoteException{
        return (a+b);
    }
    Adder1() throws RemoteException {
        super();
    }
    Adder1 ( int port  ) throws RemoteException{
        super(port);
    }
    RemoteStub
}


public class Server {
    public static void main(String[] args) {
        try {
            UnicastRemoteObject obj = new Adder1();
            Naming.bind("AddTwoNumber",obj);
            RemoteRef ref= obj.getRef();

        }

        catch(Exception e){
            System.out.println("Exception caught on server side : "+ e.getMessage());
        }
        File file = new  File("C:\\Users\\RANA1947\\rmi")
    }
}
*/
