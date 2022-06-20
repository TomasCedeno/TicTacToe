package Logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import logic.SocketConnection;

public class Server implements SocketConnection{
    
    private ServerSocket server;
    private Socket client;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private int port = 5000;

    public Server() throws IOException {
        server = new ServerSocket(port);
            
        System.out.println("Esperando por oponente...");

        client = server.accept();

        System.out.println("Conected " + client.getInetAddress().getHostAddress());

        dataIn = new DataInputStream(client.getInputStream());
        dataOut = new DataOutputStream(client.getOutputStream()); 
    }    
    
    @Override
    public void sendMove(int move){
        try{
            dataOut.writeInt(move); 
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    @Override
    public int getMove(){
        try{
            return dataIn.readInt(); 
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return -1;
    }
    
    @Override
    public void close(){
        try{
            dataIn.close();
            dataOut.close();
            client.close(); 
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }

}