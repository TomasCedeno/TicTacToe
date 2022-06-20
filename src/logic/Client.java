package Logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import logic.SocketConnection;

public class Client implements SocketConnection{
    
    private Socket myServer;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private byte message[] = new byte[100];
    
    public Client(int portS, String route) throws IOException {          
        myServer = new Socket(route, portS);
        
        dataIn = new DataInputStream(myServer.getInputStream());
        dataOut = new DataOutputStream(myServer.getOutputStream());         
    }
    
    @Override
    public void sendInfo(String info){
        try{
            dataOut.write(info.getBytes());
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    @Override
    public String[] getInfo(){
        try{
            dataIn.read(message);
            String[] info = new String(message).trim().split(":");
            return info;
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return null;
    }
    
    @Override
    public void close(){
        try{
            dataIn.close();
            dataOut.close();
            myServer.close(); 
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
}
