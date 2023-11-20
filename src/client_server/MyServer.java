package client_server;
import java.net.*;
import java.io.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666,2);

            Socket s = ss.accept();
            Socket s1 = ss.accept();
            Socket s2 = ss.accept();
            System.out.println("Connection 1 : ("+s.getLocalAddress()+","+s.getLocalPort()+","+s.getRemoteSocketAddress());
            System.out.println("Connection 2: ("+s1.getLocalAddress()+","+s1.getLocalPort()+","+s1.getRemoteSocketAddress());
            System.out.println("Connection 3 : ("+s2.getLocalAddress() +","+s2.getLocalPort() + ","+s2.getRemoteSocketAddress());
            System.out.println("ServerSocked successfully established the connection ");
            SocketAddress temp = s.getRemoteSocketAddress();
            System.out.println("Properties of socket returned by ServerSocket class ");
            System.out.println("LocalAddress : "+s.getLocalAddress());
            System.out.println("port " + s.getPort());
            System.out.println("local port : "+s.getLocalPort());
            System.out.println("send buffer size : "+s.getSendBufferSize());
            System.out.println("Receive buffer size : "+s.getReceiveBufferSize());
            System.out.println("RemoteSocket Address for server : "+ temp.toString());
            DataOutputStream ds = new DataOutputStream ( s.getOutputStream());
            ds.writeInt( 2);
            ds.writeUTF("Hello World");
            ds.writeDouble(22.2);
            s.close();

            System.out.println("Taking exit from the server program");
        }
        catch (Exception e){
            System.out.println(" Exception thrown : "+e.getMessage());
        }
    }
}
