package logic;


public interface SocketConnection{
    
    public void sendMove(int move);
    
    public int getMove();
    
    public void close();
}
