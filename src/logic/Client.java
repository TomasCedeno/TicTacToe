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
    
    public Client(int portS, String route) throws IOException {          
        myServer = new Socket(route, portS);
        
        dataIn = new DataInputStream(myServer.getInputStream());
        dataOut = new DataOutputStream(myServer.getOutputStream());         
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
            int move = dataIn.readInt();
            return move;
        } catch(IOException ex){
            System.out.println("Error: "+ex.getMessage());
        }
        return 0;
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
