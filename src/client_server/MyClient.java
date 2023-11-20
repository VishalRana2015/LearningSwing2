package client_server;
import java.net.*;
import java.io.*;
public class MyClient {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 6666);
            Socket s1 = new Socket("localhost", 6666);
            Socket s2 = new Socket( "localhost",6666);

            System.out.println("Connection 1 : ("+s.getLocalAddress()+","+s.getLocalPort()+","+s.getRemoteSocketAddress());
            System.out.println("Connection 2: ("+s1.getLocalAddress()+","+s1.getLocalPort()+","+s1.getRemoteSocketAddress());
            System.out.println("Connection 3 : ("+s2.getLocalAddress() +","+s2.getLocalPort() + ","+s2.getRemoteSocketAddress());

            DataInputStream ds = new DataInputStream( s.getInputStream());
            SocketAddress temp = s.getRemoteSocketAddress();
            System.out.println("Remote SocketAddress for client side socket : " + temp.toString());
            System.out.println(ds.readInt());
            System.out.println(ds.readUTF());
            System.out.println(ds.readDouble());
            System.out.println("Taking exit from the client program.");
        }
        catch(Exception e ){
            System.out.println("Exception thrown on client side : "+ e.getMessage());
        }

    }
}
